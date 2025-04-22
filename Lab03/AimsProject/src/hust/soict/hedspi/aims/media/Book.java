package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors= new ArrayList<String>();
    public Book(String title){
        super(title);
    }
    public Book(String title, String category, float cost){
        super(title, category, cost);
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
