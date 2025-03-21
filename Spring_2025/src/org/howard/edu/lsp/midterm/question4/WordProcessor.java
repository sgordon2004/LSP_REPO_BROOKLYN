package org.howard.edu.lsp.midterm.question4;
import java.util.*;

/**
 * Sources:
 * https://www.w3schools.com/java/ref_string_trim.asp
 * https://www.w3schools.com/java/java_regex.asp
 */

public class WordProcessor {
    private String sentence; // sentence to be processed

    // constructor
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * This method finds and returns the longest word(s) in a sentence.
     * @return
     */
    public List<String> findLongestWords() {
        if (sentence == null || sentence.trim().isEmpty()) { // handles empty input
            return new ArrayList<>(); // Return empty list for null or empty input
        }

        // format the sentence to remove punctuation and whitespace
        // splits sentence into individual words
        String[] words = sentence.replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
        
        List<String> longestWords = new ArrayList<>(); // stores longest words in sentence
        int maxLength = 0;

        for (String word : words) { // iterates through all words in sentence
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear(); // New longest word found, reset list
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                longestWords.add(word); // Add word if it's the same length as max
            }
        }

        return longestWords;
    }
}