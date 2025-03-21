package org.howard.edu.lsp.midterm.question5;

public class Movie extends Streamable {
    public Movie(String title, String director) {
        super(title, director);
    }
    /**
     * this method rewinds the movie by a specified number of seconds.
     * @param seconds	amount of secs to go back in movie
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding \"" + title + "\" by " + seconds + " seconds.");
    }

    @Override
    protected String getType() {
        return "Movie";
    }
}