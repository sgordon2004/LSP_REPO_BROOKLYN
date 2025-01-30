package org.howard.edu.lsp.assignment2;

//Importing required classes 
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
	List<Map<String, String>> dataList = new ArrayList<>(); // instantiating list to hold all maps
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Relative path to file
		String relativePath = "data/products.csv";
		// Instantiating ETL class
		ETL processor = new ETL();
		processor.reader(relativePath);
		processor.transformer(processor.dataList);
	}
	// EXTRACT
	// Method to read a .csv file
	public void reader(String fileName) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			String line;
			int counter = 0;
			String[] headers = null; // array to store header values
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
	public void transformer(List<Map<String, String>> dataList) {
		// Apply 10% discount to products in "Electronics" category
		for (int i = 0; i < dataList.size(); i++) { // iterates through each map in dataList
			Map<String, String> map = dataList.get(i);
			if (map.get("Category").equals("Electronics")) {
				System.out.print(map + "\n");
			}
		}
	}
}
