package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors= new ArrayList<String>();
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
    public void addAuthor(String AuthorName){
        if (!authors.contains(AuthorName)) {
            authors.add(AuthorName);
            System.out.println("Added author: " + AuthorName);
        } else {
            System.out.println("Author already exists: " + AuthorName);
        }
    }
    public void removeAuthor(String AuthorName){
        if (authors.contains(AuthorName)) {
            authors.remove(AuthorName);
            System.out.println("Removed author: " + AuthorName);
        } else {
            System.out.println("Author not found: " + AuthorName);
        }
    }
}
