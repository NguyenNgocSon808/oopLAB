package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;
    private String director;
    
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public Disc(String title) {
        super(title);
    }
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }
    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    public String toString(){
        return null;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Disc)) return false;
        Disc other = (Disc) obj;
        if (this.getTitle() == null || other.getTitle() == null) return false;
        return this.getTitle().equals(other.getTitle()) && Float.compare(this.getCost(), other.getCost()) == 0;
    }
}