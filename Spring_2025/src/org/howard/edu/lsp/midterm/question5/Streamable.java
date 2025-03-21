package org.howard.edu.lsp.midterm.question5;

/**
* Sources: 
**/

// using an abstract class for shared behavior
public abstract class Streamable {
	protected String title;
	protected String creator;
 
	// constructor
	 public Streamable(String title, String creator) {
	     this.title = title;
	     this.creator = creator;
	 }
	
	 /**
	  * this method plays the media.
	  */
	 public void play() {
	     System.out.println("Streaming " + getType() + ": \"" + title + "\" by " + creator);
	 }
	 /**
	  * this method pauses the media.
	  */
	 public void pause() {
	     System.out.println(getType() + " \"" + title + "\" is paused.");
	 }
	 /**
	  * this method stops the media completely.
	  */
	 public void stop() {
	     System.out.println(getType() + " \"" + title + "\" has stopped.");
	 }
	
	 // each subclass will implement its specific type
	 protected abstract String getType();
	}