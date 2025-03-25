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
//		System.out.println("Integer set cleared."); // Debugging message
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
		if (o == null || !(o instanceof IntegerSet)) { // returns false if set is null or not an IntegerSet
			return false;
		}
		if (o == this) { // if o is the same object as this they are obviously equal
			return true;
		}
		
		IntegerSet set = (IntegerSet) o; // cast o to integer set
		
		if (set.set.size() != this.set.size()) { // if the two sets are not the same length they are not equal (since there are no dupes_
			return false;
		}
		
	
		// compare the elements
		
		if (set.set.containsAll(this.set) && this.set.containsAll(set.set)) {
			return true; // returns false on first encounter with integer that is not in both sets
		}
	return false;
		
	}
	
	// Returns true if the set contains the value, otherwise false. 5 pts.
	public boolean contains(int value) {
		return set.contains(value);
	}
	
	// Returns the largest item in the set. 5 pts.
	public int largest() {
		if (this.isEmpty()) {
	        throw new RuntimeException("Cannot determine largest element: the set is empty.");
	    }
		
		int largest = set.get(0); // start with first element
		
		for (int i = 1; i < set.size(); i++) {
			if (set.get(i) > largest) {
				largest = set.get(i);
			}
		}
		
		return largest;
	}
	
	// Returns the smallest item in the set. 5 pts.
	public int smallest() {
		if (this.isEmpty()) {
	        throw new RuntimeException("Cannot determine smallest element: the set is empty.");
	    }
		
		int smallest = set.get(0); // start with first element
		
		for (int i = 1; i < set.size(); i++) {
			if (set.get(i) < smallest) {
				smallest = set.get(i);
			}
		}
		
	    return smallest;
		
	}
	
	// Adds an item to the set or does nothing if already there. 5 pts.
	public void add(int item) { // adds item to the set or does nothing if it is in set
		// do nothing if item is in set
		if (set.contains(item)) {
			return;
		}
		else { // add item to set
			set.add(item);
//			System.out.println(item + " added to set."); // debugging message
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
//			System.out.println(item + " removed from set.");
		}
	}
	
	// Set union. 11 pts.
	public void union(IntegerSet intSetb) {
		for (Integer item : intSetb.set) {
		    if (!this.set.contains(item)) { // avoids adding duplicates
		        this.set.add(item);
		    }
		}
	}
	
	// Set intersection, all elements in s1 and s2. 12 pts.
	public void intersect(IntegerSet intSetb) {
		// if the sets are equal, either set is the intersection of both
		if (!this.equals(intSetb)) {
			this.set.retainAll(intSetb.set);
		}
		// else: sets are already equal so there is no need to change anything
	}
	
	// Set difference, i.e., s1 –s2. 12 pts.
	public void diff(IntegerSet intSetb) {
		this.set.removeAll(intSetb.set); // predefined Java method to remove all elements in input from set calling it
	}
	
	// Set complement, all elements not in s1. 11 pts.
	public void complement(IntegerSet intSetb) {
		List<Integer> result = new ArrayList<>(intSetb.set);
	    result.removeAll(this.set);
	    this.set = result;
	}
	// Returns true if the set is empty, false otherwise. 5 pts.
	boolean isEmpty() {
		if (length() == 0) {
			return true;
		}
		
		return false;
	}
	
	// Return String representation of your set. This overrides the toString method from
	// the Object class. 5 pts.
	@Override
	public String toString() {
		return set.toString();
	}
}