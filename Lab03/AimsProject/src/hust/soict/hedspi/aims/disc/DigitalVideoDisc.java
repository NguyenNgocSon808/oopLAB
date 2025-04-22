package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    public DigitalVideoDisc(String title) {
        nbDigitalVideoDiscs++; 
        this.id = nbDigitalVideoDiscs;
        this.title = title;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        nbDigitalVideoDiscs++; 
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        nbDigitalVideoDiscs++; 
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        nbDigitalVideoDiscs++; 
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public int getID() {
        return id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DigitalVideoDisc disc = (DigitalVideoDisc) obj;
        return length == disc.length &&
               Float.compare(disc.cost, cost) == 0 &&
               title.equals(disc.title) &&
               ((category == null && disc.category == null) || (category != null && category.equals(disc.category))) &&
               ((director == null && disc.director == null) || (director != null && director.equals(disc.director)));
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString(){
        return (id + ". DVD - " + this.getTitle() + 
        " - " + this.getCategory() + 
        " - " + this.getDirector() + 
        " - " + this.getLength() + 
        ": " + this.getCost() + ".");
    }

    public boolean isMatch(String title){
        if(this.title == title) return true;
        return false;
    }

    public boolean isMatch(int id){
        if(this.id == id) return true;
        return false;
    }
}
