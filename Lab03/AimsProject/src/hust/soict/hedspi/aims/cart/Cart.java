package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.*;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    public void addMedia(Media media){
        if(itemsOrdered.contains(media)){
            System.out.println("This media already exists!");
        }else{
            itemsOrdered.add(media);
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

    public void SearchMedia(int id){
        for(Media media : itemsOrdered){
            if(media.isMatch(id)){
                System.out.println(media.toString());
                return;
            }
        }
        System.out.println("No result matched");
    }
    
    public void SearchMedia(String title){
        for(Media media : itemsOrdered){
            if(media.isMatch(title)){
                System.out.println(media.toString());
                return;
            }
        }
        System.out.println("No result matched");
    }
}
