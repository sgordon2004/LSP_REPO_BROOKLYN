package org.howard.edu.lsp.assignment2;

//Importing required classes 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * Requirements:
 * 1. Read .csv file from a relative directory named data located in
      the project root folder.
      
  	Formatting Help:
  	Class: ETLProcessor ✅ (PascalCase)
	Method: readCsvFile() ✅ (camelCase)
	Variable: filePath ✅ (camelCase)
	Constant: DEFAULT_DISCOUNT ✅ (UPPER_SNAKE_CASE)
 */

public class ETL {
	

	public static void main(String[] args) {
		
		// Relative path to file
		String relativePath = "data/products.csv";
		String outputPath = "data/transformed_products.csv";
		// Instantiating ETL class
		ETL processor = new ETL();
		processor.reader(relativePath);
		List<Map<String, String>> data = processor.transformer(processor.dataList);
//		for (int i = 0; i < data.size(); i++) {
//			System.out.print(data.get(i) + "\n");
//		}
		processor.writeCSV(outputPath, data);
	}
	
	// Save .csv header data
	private String[] headers;
	// Instantiating list to hold all maps
	List<Map<String, String>> dataList = new ArrayList<>();
	
	
	// EXTRACT
	// Method to read a .csv file
	public void reader(String fileName) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			String line;
			int counter = 0;
			while ((line = bufferedReader.readLine()) != null) { // Reads line by line until EOF
				if (line.isEmpty()) { // checks if line is empty
					continue; // if a line is empty, it is not printed
				} else {
					if (counter == 0) { // Saves first line (headers) to list of header values
						headers = line.split(",");
					} else {
						mapToList(lineToMap(line, headers)); // converts the .csv line to a map and then adds that map to an array
					}
				}
				counter = 1;
			}
//			System.out.print(dataList.size()  + "\n");
//			for (int i = 0; i < dataList.size(); i++) {
//				System.out.print(dataList.get(i) + "\n");
//			}
			
		} catch (IOException e) { // Catches Input/Output error
			System.out.println("Error: " + e.getMessage()); // Prints detailed error message
		}
	}
	
	// TRANSFORM
	// function to convert each line to a map
	public Map<String, String> lineToMap(String line, String[] headers) { // function returning a hashMap from csv lines
		String[] values = line.split(","); // Splits .csv lines by commas
		Map<String, String> rowMap = new LinkedHashMap<>(); // Instantiating a new LinkedHashMap to store data
		
		for (int i = 0; i < headers.length; i++) {
			rowMap.put(headers[i], values[i]); // Maps column name to value
		}
		return rowMap;
	}
	
	// function to add each map to a list
	public void mapToList(Map<String, String> map) {
		dataList.add(map);
	}
	
	// Function to apply necessary changes
	public List<Map<String, String>> transformer(List<Map<String, String>> dataList) {
		// Apply 10% discount to products in "Electronics" category
		for (int i = 0; i < dataList.size(); i++) { // iterates through each map in dataList
			Map<String, String> map = dataList.get(i);
			electronicsTransformer(map);
			caseChanger(map);
			priceRanger(map);
		}
		return dataList;
	}
	
	/***
	 * Function to apply 10% discount to Electronics and 
	 * change category of those over $500.
	 * @param map (a map of a single .csv line)
	 * @return map (new map of input .csv line with updated price/category)
	 */
	public Map<String, String> electronicsTransformer(Map<String, String> map) {
		if (map.get("Category").equals("Electronics")) {
			double originalPrice = Double.parseDouble(map.get("Price"));
//			System.out.print("Original Price: " + Double.toString(originalPrice) + "\n");
			double discountedPrice = originalPrice - (originalPrice * .1); // Apply 10% discount
			BigDecimal roundedPrice = new BigDecimal(discountedPrice).setScale(2, RoundingMode.HALF_UP); // Rounding to nearest 100th (BigDecimal is more precise for rounding
//			System.out.print("Discounted Price: " + roundedPrice + "\n");
			map.put("Price", roundedPrice.toString()); // Changing price in map
			
			// Changes Electronics > $500 to Premium Electronics
			if (roundedPrice.doubleValue() > 500) { 
				map.put("Category", "Premium Electronics");
			}
		}
		return map;
	}
	

	/***
	 * Function to convert all product names to upper case.
	 * @param map (a map of a single .csv line)
	 * @return map (new map with upper case product names)
	 */
	public Map<String, String> caseChanger(Map<String, String> map) {
		String lowerName = map.get("Name"); // store original lower case name
		String upperName = lowerName.toUpperCase(); // covert name to upper case
		map.put("Name", upperName); // update map
		
		return map;
	}
	
	/***
	 * Function to assign a price range to all items.
	 * Low: 0 - 10
	 * Med: 10.01 - 100
	 * High: 100.01 - 500
	 * Prem: 500.01+
	 * @param map (a map of a single .csv line)
	 * @return map (new map with updated PriceRange field)
	 */
	public Map<String, String> priceRanger(Map<String, String> map) {
		// Check price
		String stringPrice = map.get("Price");
		Double doublePrice = Double.parseDouble(stringPrice);
		// Price Range
		if (doublePrice < 10.01) {
			map.put("PriceRange", "Low");
		} else if (doublePrice >= 10.01 && doublePrice < 100.01) {
			map.put("PriceRange", "Medium");
		} else if (doublePrice >= 100.01 && doublePrice < 500.01) {
			map.put("PriceRange", "High");
		} else {
			map.put("PriceRange", "Premium");
		}
		
		return map;
	}
	
	// LOAD
	
	
	public void writeCSV(String filePath, List<Map<String, String>> dataList) {
		// Write header row
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			if (headers != null) {
				writer.write(String.join(",", headers));
				writer.newLine();
			}
			
			for (Map<String, String> row : dataList ) {
				List<String> values = new ArrayList<>();
				for (String header : headers) {
					values.add(row.getOrDefault(header, ""));
				}
				writer.write(String.join(",", values));
				writer.newLine();
			}
			
			System.out.println("CSV file written successfully!");
		} catch (IOException e) {
			System.out.println("Error writing CSV file: " + e.getMessage());
		}
	}
	
	
	}

