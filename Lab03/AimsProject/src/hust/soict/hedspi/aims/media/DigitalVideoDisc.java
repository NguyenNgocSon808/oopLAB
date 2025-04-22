package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DigitalVideoDisc disc = (DigitalVideoDisc) obj;
        return this.getLength() == disc.getLength() &&
               Float.compare(disc.getCost(), this.getCost()) == 0 &&
               this.getTitle().equals(disc.getTitle()) &&
               ((this.getCategory() == null && disc.getCategory() == null) || (this.getCategory() != null && this.getCategory().equals(disc.getCategory()))) &&
               ((this.getDirector() == null && disc.getDirector() == null) || (this.getDirector() != null && this.getDirector().equals(disc.getDirector())));
    }
    @Override
    public String toString(){
        return (this.getId() + ". DVD - " + this.getTitle() + 
        " - " + this.getCategory() + 
        " - " + this.getDirector() + 
        " - " + this.getLength() + 
        ": " + this.getCost() + ".");
    }

    public boolean isMatch(String title){
        if(this.getTitle() == title) return true;
        return false;
    }

    public boolean isMatch(int id){
        if(this.getId() == id) return true;
        return false;
    }
}
