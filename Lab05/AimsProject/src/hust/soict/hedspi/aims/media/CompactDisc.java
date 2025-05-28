package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>(); 
    public String getArtist() {
        return artist;
    }
    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public CompactDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    public CompactDisc(String title, String category, String director, String artist,  int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" added.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" removed.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" is not in the CD.");
        }
    }
    public int getLength(){
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public void play() throws hust.soict.hedspi.aims.exception.PlayerException {
        if (tracks.isEmpty()) {
            throw new hust.soict.hedspi.aims.exception.PlayerException("ERROR: CD has no tracks!");
        }
        System.out.println("Playing CD: " + this.getTitle());
        for(Track track : tracks){
            try {
                track.play();
            } catch (hust.soict.hedspi.aims.exception.PlayerException e) {
                System.err.println("Track Play Exception:");
                System.err.println("Message: " + e.getMessage());
                System.err.println("Exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }
    @Override
    public String toString(){
        return (this.getId() + ". CD - " + this.getTitle() + 
        " - " + this.getCategory() + 
        " - " + this.getDirector() + 
        " - " + this.getLength() + 
        " - " + this.getArtist() +
        ": " + this.getCost() + ".");
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof CompactDisc)) return false;
        CompactDisc other = (CompactDisc) obj;
        if (this.getTitle() == null || other.getTitle() == null) return false;
        return this.getTitle().equals(other.getTitle()) && Float.compare(this.getCost(), other.getCost()) == 0;
    }
}