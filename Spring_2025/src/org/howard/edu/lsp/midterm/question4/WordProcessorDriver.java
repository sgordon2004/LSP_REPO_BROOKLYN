package org.howard.edu.lsp.midterm.question4;

import java.util.List;

public class WordProcessorDriver {
    public static void main(String[] args) {
        // Test case 1: Sentence with a single longest word
        WordProcessor wp1 = new WordProcessor("This is a test with amazing results, amazing achievements!");
        List<String> longestWords1 = wp1.findLongestWords();
        System.out.println("Test 1 - Longest words: " + longestWords1);
        // Expected Output: ["achievements"]

        // Test case 2: Multiple occurrences of longest word
        WordProcessor wp2 = new WordProcessor("Java is a powerful, powerful tool!");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + longestWords2);
        // Expected Output: ["powerful", "powerful"]

        // Test case 3: Single-character words
        WordProcessor wp3 = new WordProcessor("A B C D E");
        List<String> longestWords3 = wp3.findLongestWords();
        System.out.println("Test 3 - Longest words: " + longestWords3);
        // Expected Output: ["A", "B", "C", "D", "E"]

        // Test case 4: Empty string input
        WordProcessor wp4 = new WordProcessor("");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Test 4 - Longest words: " + longestWords4);
        // Expected Output: []
    }
}