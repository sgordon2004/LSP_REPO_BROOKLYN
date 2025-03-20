package org.howard.edu.lsp.midterm.question3;
import java.util.HashMap;
import java.util.Map;
/**
 * Sources:
 * https://www.geeksforgeeks.org/map-interface-java-examples/
 * https://www.w3schools.com/java/java_hashmap.asp
 */

public class VotingMachine {
	// create map to store votes with candidate as key and number of votes
	// they received as value
	private Map<String, Integer> votes;
	
	// Constructor
	public VotingMachine() {
		votes = new HashMap<>();
	}
	
	/**
	 * This method adds a new candidate to the ballot
	 * with 0 votes since nobody starts with a vote.
	 * @param candidate		the political candidate on the ballot
	 */
	public void addCandidate(String candidate) {
		if (!votes.containsKey(candidate)) {
			votes.put(candidate, 0);
		}
	}
	/**
	 * This method adds one vote to the candidate if they exist.
	 * @param candidate		the candidate being voted for
	 * @return boolean		true if successful, false if candidate not on ballot
	 */
    public boolean castVote(String candidate) {
        if (votes.containsKey(candidate)) { // if candidate exists
            votes.put(candidate, votes.get(candidate) + 1); // incrementing the value by 1
            return true; // Vote was successful
        }
        return false; // Candidate does not exist
    }
    /**
     * This method returns the candidate with the highest
     * number of votes, which means they won the election.
     * @return String		tells you which candidate won
     */
    public String getWinner() {
    	String winner = null;
        int maxVotes = -1;
        
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner + " WINS with " + maxVotes + " votes!!";
    }

}