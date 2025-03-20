package org.howard.edu.lsp.midterm.question2;

/**
 * 
 * This driver method instantiates
 * Book objects.
 */
public class BookDriver {
	public static void main(String[] args) {
		// Instantiating Book objects
		Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);
        
        // checking equality
    	System.out.println(book1.equals(book2)); // true
        System.out.println(book1.equals(book3)); // false
        
        // print book details
        System.out.println(book1);
	}
	
}