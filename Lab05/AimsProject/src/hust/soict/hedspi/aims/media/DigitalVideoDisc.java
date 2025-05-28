package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(String title) {
        super(title);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    @Override
    public String toString(){
        return (this.getId() + ". DVD - " + this.getTitle() + 
        " - " + this.getCategory() + 
        " - " + this.getDirector() + 
        " - " + this.getLength() + 
        ": " + this.getCost() + ".");
    }
    @Override
    public void play() throws hust.soict.hedspi.aims.exception.PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            hust.soict.hedspi.aims.exception.PlayerException ex = new hust.soict.hedspi.aims.exception.PlayerException("ERROR: DVD length is non-positive!");
            System.err.println("DVD Play Exception:");
            System.err.println("Message: " + ex.getMessage());
            System.err.println("Exception: " + ex.toString());
            ex.printStackTrace();
            throw ex;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof DigitalVideoDisc)) return false;
        DigitalVideoDisc other = (DigitalVideoDisc) obj;
        if (this.getTitle() == null || other.getTitle() == null) return false;
        return this.getTitle().equals(other.getTitle()) && Float.compare(this.getCost(), other.getCost()) == 0;
    }
}