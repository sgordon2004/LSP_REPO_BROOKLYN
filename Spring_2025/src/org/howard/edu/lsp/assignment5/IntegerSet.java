package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
	
	// Store the set elements in an ArrayList.
	private List<Integer> set = new ArrayList<Integer>();
	
	// Default Constructor
	public IntegerSet() {
		
	}
	
	// Constructor if you want to pass in already initialized
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}
	
	// Clears the internal representation of the set. 5 pts.
	public void clear() {
		set.clear(); // Using predefined Java method
	}
	
	// Returns the length of the set. 5 pts.
	public int length() { // returns the length
		set.size(); // Using predefined Java method
	}
	
	/*
	* Returns true if the 2 sets are equal, false otherwise;
	* Two sets are equal if they contain all of the same values in ANY order. This overrides
	* the equal method from the Object class. 10 pts.
	*/
	public boolean equals(Object o) {
		return false;
	}
	
	// Returns true if the set contains the value, otherwise false. 5 pts.
	public boolean contains(int value) {
		return false;
	}
	
	// Returns the largest item in the set. 5 pts.
	public int largest() {
		return 0;
	}
	
	// Returns the smallest item in the set. 5 pts.
	public int smallest() {
		return 0;
	}
	
	// Adds an item to the set or does nothing it already there. 5 pts.
	public void add(int item) { // adds item to the set or does nothing if it is in set
		
	};
	
	// Removes an item from the set or does nothing if not there. 5 pts.
	public void remove(int item) {
		
	}
	
	// Set union. 11 pts.
	public void union(IntegerSet intSetb) {
		
	}
	
	// Set intersection, all elements in s1 and s2. 12 pts.
	public void intersect(IntegerSet intSetb) {
		
	}
	
	// Set difference, i.e., s1 –s2. 12 pts.
	public void diff(IntegerSet intSetb) { // set difference, i.e. s1 - s2
		
	}
	
	// Set complement, all elements not in s1. 11 pts.
	public void complement(IntegerSet intSetb) {
		
	}
	// Returns true if the set is empty, false otherwise. 5 pts.
	boolean isEmpty() {
		return false;
	};
	
	// Return String representation of your set. This overrides the equal method from
	// the Object class. 5 pts.
	public String toString() {
		return null;
	} // return String representation of your set
	}