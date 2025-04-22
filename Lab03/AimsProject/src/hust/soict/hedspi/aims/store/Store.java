package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.*;

public class Store {
    public DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[500];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore++] = dvd;
            System.out.println("DVD added: " + dvd.getTitle());
        } else {
            System.out.println("Store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(dvd)) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                    itemsInStore[j].setID(j+1);
                }
                itemsInStore[qtyInStore-1] = null;
                qtyInStore--;

                System.out.println("DVD removed: " + dvd.getTitle());
                return;
            }
        }
        System.out.println("DVD not found in store.");
    }
    public void print(){
        System.out.println("**********************************CART**********************************");

        for(int i = 0; i < qtyInStore; i++){
            System.out.println(itemsInStore[i].toString());
        }

        System.out.println("************************************************************************");        
    }
}
