package hust.soict.hedspi.aims.cart;

import java.util.Collections;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.*;
import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Media> itemsOrdered = javafx.collections.FXCollections.observableArrayList();
    public static final int MAX_NUMBERS_ORDERED = 20;
    
    public void addMedia(Media media) throws LimitExceededException {
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if(itemsOrdered.contains(media)){
                System.out.println("This media already exists!");
            }else{
                itemsOrdered.add(media);
            }
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }
    public void removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
        }else{
            System.out.println("Media not found");
        }
    }
    public float TotalCost(){
        float total = 0;
        for(Media media : itemsOrdered){
            total += media.getCost();
        }
        return total;
    }


    public void print(){
        System.out.println("**********************************CART**********************************");

        for(Media media : itemsOrdered){
            System.out.println(media.toString());
        }

        System.out.println("************************************************************************");        
    }
    public Media searchByTitle(String title){
        for(Media media : itemsOrdered){
            if(media.isMatch(title)){
                return media;
            }
        }
        return null;
    }
    public Media searchByID(int ID){
        for(Media media : itemsOrdered){
            if(media.getId() == ID){
                return media;
            }
        }
        return null;
    }
    public void sortByCost(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    public void sortByTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been emptied.");
    }   
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public int totalCost() {
        int total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    public void clear() {
        itemsOrdered.clear();
    }
}
