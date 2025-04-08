package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * The IntegerSet class represents a set of integers with no duplicates.
 * It supports standard set operations such as union, intersection, difference, and complement.
 * Internally, it uses an ArrayList to store values.
 *
 * @author Syrr Gordon
 */
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
	
	/**
	 * Removes all elements from the set.
	 */
	public void clear() {
		set.clear(); // Using predefined Java method
//		System.out.println("Integer set cleared."); // Debugging message
	}
	
	/**
	 * Returns the number of elements in the set.
	 * @return the size of the set
	 */
	public int length() { // returns the length
		return set.size(); // Using predefined Java method
	}
	
	/**
	 * Compares this set to another object for equality.
	 * Two sets are equal if they contain the same elements, regardless of order.
	 * @param o the object to compare with
	 * @return true if the sets are equal, false otherwise
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
	
	/**
	 * Checks if the set contains the specified value.
	 * @param value the value to check
	 * @return true if the value is in the set, false otherwise
	 */
	public boolean contains(int value) {
		return set.contains(value);
	}
	
	/**
	 * Returns the largest element in the set.
	 * @return the largest integer
	 * @throws RuntimeException if the set is empty
	 */
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
	
	/**
	 * Returns the smallest element in the set.
	 * @return the smallest integer
	 * @throws RuntimeException if the set is empty
	 */
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
	
	/**
	 * Adds a value to the set if it is not already present.
	 * @param item the value to add
	 */
	public void add(int item) { // adds item to the set or does nothing if it is in set
		// do nothing if item is in set
		if (set.contains(item)) {
			return;
		}
		else { // add item to set
			set.add(item);
//			System.out.println(item + " added to set."); // debugging message
		}
	}
	
	/**
	 * Removes a value from the set if it is present.
	 * @param item the value to remove
	 */
	public void remove(int item) {
		// do nothing if item is not in set
		if (!set.contains(item)) {
			return;
		}
		else { // remove item from set
			set.remove(Integer.valueOf(item));
//			System.out.println(item + " removed from set.");
		}
	}
	
	/**
	 * Modifies this set to be the union of itself and another set.
	 * @param intSetb the other set to union with
	 */
	public void union(IntegerSet intSetb) {
		for (Integer item : intSetb.set) {
		    if (!this.set.contains(item)) { // avoids adding duplicates
		        this.set.add(item);
		    }
		}
	}
	
	/**
	 * Modifies this set to be the intersection of itself and another set.
	 * @param intSetb the other set to intersect with
	 */
	public void intersect(IntegerSet intSetb) {
		// if the sets are equal, either set is the intersection of both
		if (!this.equals(intSetb)) {
			this.set.retainAll(intSetb.set);
		}
		// else: sets are already equal so there is no need to change anything
	}
	
	/**
	 * Removes all elements in the other set from this set.
	 * @param intSetb the other set whose elements will be removed from this one
	 */
	public void diff(IntegerSet intSetb) {
		this.set.removeAll(intSetb.set); // predefined Java method to remove all elements in input from set calling it
	}
	
	/**
	 * Replaces this set with the complement relative to another set.
	 * This will remove all elements of this set from the other set,
	 * and assign the result to this set.
	 * @param intSetb the universal set to compare against
	 */
	public void complement(IntegerSet intSetb) {
		List<Integer> result = new ArrayList<>(intSetb.set);
	    result.removeAll(this.set);
	    this.set = result;
	}
	
	/**
	 * Checks if the set is empty.
	 * @return true if the set has no elements, false otherwise
	 */
	boolean isEmpty() {
		if (length() == 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns a string representation of the set.
	 * @return a string in the format [element1, element2, ...]
	 */
	@Override
	public String toString() {
		return set.toString();
	}
}