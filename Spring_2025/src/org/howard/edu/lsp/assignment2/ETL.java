package org.howard.edu.lsp.assignment2;

//Importing required classes 
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 


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
		// TODO Auto-generated method stub
		
		// Relative path to file
		String relativePath = "data/products.csv";
		// Instantiating ETL class
		ETL processor = new ETL();
		processor.reader(relativePath);
	}
	
	// Method to read a .csv file
	public void reader(String fileName) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) { // Reads line by line until EOF
				if (line.isEmpty()) { // checks if line is empty
					continue; // if a line is empty, it is not printed
				} else {
					System.out.println(line);
				}
				
			}
		} catch (IOException e) { // Catches Input/Output error
			System.out.println("Error: " + e.getMessage()); // Prints detailed error message
		}
	}
}
