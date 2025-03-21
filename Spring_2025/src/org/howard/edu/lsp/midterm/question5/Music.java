package org.howard.edu.lsp.midterm.question5;

public class Music extends Streamable {
    public Music(String title, String artist) {
        super(title, artist); //super keyword refers to superclass' constructor
    }
    /**
     * This method adds the song playing to a playlist.
     * @param playlistName		playlist to add song to
     */
    public void addToPlaylist(String playlistName) {
    	System.out.println("Adding " + title + "to playlist " + playlistName + ".");
    }
    
    /**
     * this method overrides getType to give it the proper type.
     */
    @Override
    protected String getType() {
        return "Music";
    }
}