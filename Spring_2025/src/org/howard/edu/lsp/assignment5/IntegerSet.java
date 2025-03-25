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
		System.out.println("Integer set cleared."); // Debugging message
	}
	
	// Returns the length of the set. 5 pts.
	public int length() { // returns the length
		return set.size(); // Using predefined Java method
	}
	
	/*
	* Returns true if the 2 sets are equal, false otherwise;
	* Two sets are equal if they contain all of the same values in ANY order. This overrides
	* the equal method from the Object class. 10 pts.
	*/
	@Override 
	public boolean equals(Object o) {
		return false;
	}
	
	// Returns true if the set contains the value, otherwise false. 5 pts.
	public boolean contains(int value) {
		return set.contains(value);
	}
	
	// Returns the largest item in the set. 5 pts.
	public int largest() {
		
		int largest = 0;
		
		for (int i = 0; i < length(); i++) {
			if (i > largest) {
				largest = i;
			}
			else {
				continue;
			}
		}
		
		return largest;
	}
	
	// Returns the smallest item in the set. 5 pts.
	public int smallest() {
		
		double inf = Double.POSITIVE_INFINITY;
		double smallest = inf; // infinitely large place holder
		
		for (int i = 0; i < length(); i++) {
			if (i < smallest) {
				smallest = i;
			}
			else {
				continue;
			}
		}
		
	    int smallestInt = (int) smallest; // converting smallest from double to integer
		return smallestInt;
		
	}
	
	// Adds an item to the set or does nothing if already there. 5 pts.
	public void add(int item) { // adds item to the set or does nothing if it is in set
		// do nothing if item is in set
		if (set.contains(item)) {
			return;
		}
		else { // add item to set
			set.add(item);
			System.out.println(item + " added to set."); // debugging message
		}
	};
	
	// Removes an item from the set or does nothing if not there. 5 pts.
	public void remove(int item) {
		// do nothing if item is not in set
		if (!set.contains(item)) {
			return;
		}
		else { // remove item from set
			set.remove(item);
			System.out.println(item + " removed from set.");
		}
	}
	
	// Set union. 11 pts.
	public void union(IntegerSet intSetb) {
		List<Integer> union = new ArrayList<Integer>(); // stores union of the two sets
		// add original set to union set
		union.addAll(set);
		// add input set to union set
		union.addAll(intSetb.set);
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