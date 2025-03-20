/**
 * I used the following sources:
 * https://www.w3schools.com/java/java_encapsulation.asp
 * https://www.tutorialspoint.com/java/lang/object_getclass.htm
 * https://www.w3schools.com/java/java_type_casting.asp
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
	
	/**
	 * This method overrides equals to allow two
	 * books to be considered equal if they have
	 * the same ISBN and author.
	 * @obj		the Object being compared to a Book
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { // if the object calling equals points to the same memory location as the object being compared to, they must be the same book
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) { // object is null or not an instance of Book
			return false;
		}
		Book otherBook = (Book) obj; // Typecasting obj to Book
		return this.ISBN.equals(otherBook.ISBN) && this.author.equals(otherBook.author);
	}
}