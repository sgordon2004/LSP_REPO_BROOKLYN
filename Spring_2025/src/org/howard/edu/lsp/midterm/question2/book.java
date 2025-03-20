/**
 * I used the following sources: https://www.w3schools.com/java/java_encapsulation.asp
 */
package org.howard.edu.lsp.midterm.question2;

/**
 * This class serves to represent a Book
 * with a title, author, ISBN, and publishing year.
 */
public class Book {
	// private attributes to remain mindful of encapsulation
	private String title;
	private String author;
	private String ISBN;
	private int yearPublished;
	
	/**
	 * This is a constructor, meant to initialize
	 * Book with the proper attributes as soon as it
	 * is instantiated.
	 * @param title
	 * @param author
	 * @param ISBN
	 * @param yearPublished
	 */
	public Book(String title, String author, String ISBN, int yearPublished) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.yearPublished = yearPublished;
	}
	
	// getters
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getISBN() {
		return ISBN;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	
	// setters
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
}