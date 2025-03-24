package Aims;

public class DigitalVideoDisc {
    private String title;
    private String categorry;
    private String director;
    private int length;
    private float cost;
    public String getTitle() {
        return title;
    }
    public String getCategorry() {
        return categorry;
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
    public DigitalVideoDisc(String title, String categorry, String director, int length, float cost) {
        this.title = title;
        this.categorry = categorry;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public void addDVD(DigitalVideoDisc dvd){
        
    }
}
