package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public static final int MAX_NUMBERS_ORDERED = 20;
    
    public void addMedia(Media media) throws LimitExceededException {
        if(itemsInStore.size() < MAX_NUMBERS_ORDERED) {
            if(itemsInStore.contains(media)){
                System.out.println("This media already exists!");
            }else{
                itemsInStore.add(media);
            }
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }
    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            itemsInStore.remove(media);
        }else{
            System.out.println("Media not found");
        }
    }
    public void print(){
        System.out.println("*********************************STORE**********************************");

        for(Media media : itemsInStore){
            System.out.println(media.toString());
        }

        System.out.println("************************************************************************");        
    }
    public Media searchByTitle(String title){
        for(Media media : itemsInStore){
            if(media.isMatch(title)){
                return media;
            }
        }
        return null;
    }
    public Media searchByID(int ID){
        for(Media media : itemsInStore){
            if(media.getId() == ID){
                return media;
            }
        }
        return null;
    }
    public ArrayList<Media> getItemsInStore(){
        return this.itemsInStore;
    }
}
