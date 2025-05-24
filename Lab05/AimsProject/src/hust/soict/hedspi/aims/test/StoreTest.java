package hust.soict.hedspi.aims.test;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", null, 0, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 29.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 22.50f);

        try {
            store.addMedia(dvd1);
            store.addMedia(dvd2);
            store.addMedia(dvd3);
            store.addMedia(dvd4);
            store.addMedia(dvd5);
        } catch (Exception e) {
            System.out.println("Failed to add media: " + e.getMessage());
        }

        store.print();

        store.removeMedia(dvd1);
        store.removeMedia(dvd4);

        store.print();
    }
}
