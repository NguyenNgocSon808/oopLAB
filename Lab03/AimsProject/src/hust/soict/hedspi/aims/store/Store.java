package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.*;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media){
        if(itemsInStore.contains(media)){
            System.out.println("This media already exists!");
        }else{
            itemsInStore.add(media);
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
        System.out.println("**********************************CART**********************************");

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
}
