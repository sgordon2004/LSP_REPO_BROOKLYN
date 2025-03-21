package org.howard.edu.lsp.midterm.question5;

public class Audiobook extends Streamable {
    public Audiobook(String title, String author) {
        super(title, author);
    }
    /**
     * this method sets the playback speed of the audio book
     * @param speed		the speed at which to play the audio book
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of \"" + title + "\" to " + speed + "x.");
    }

    @Override
    protected String getType() {
        return "Audiobook";
    }
}