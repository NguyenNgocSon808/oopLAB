package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import hust.soict.hedspi.aims.comparator.*;
import hust.soict.hedspi.aims.comparator.MediaComparatorByTitleCost;

public abstract class Media {
    private static int nbMedia = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public Media(String title){
        nbMedia++;
        this.id = nbMedia;
        this.title = title;
    }
    public Media(String title, String category, float cost){
        nbMedia++;
        this.id = nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public String toString(){
        return null;
    }
    public boolean isMatch(int id){
        if(this.getId() == id) return true;
        return false;
    }
    public boolean isMatch(String title){
        if(this.title.equals(title)) return true;
        return false;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;
        if (this.getTitle() == null || other.getTitle() == null) return false;
        return this.getTitle().equals(other.getTitle()) && Float.compare(this.getCost(), other.getCost()) == 0;
    }

    public int compareTo(Object obj) {
        if (obj == null) throw new NullPointerException("Compared object is null");
        if (!(obj instanceof Media)) throw new ClassCastException("Object is not a Media");
        Media other = (Media) obj;
        int titleCompare = (this.getTitle() == null ? (other.getTitle() == null ? 0 : -1) : (other.getTitle() == null ? 1 : this.getTitle().compareTo(other.getTitle())));
        if (titleCompare != 0) return titleCompare;
        return Float.compare(this.getCost(), other.getCost());
    }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}