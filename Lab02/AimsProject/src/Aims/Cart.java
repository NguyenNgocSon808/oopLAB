package Aims;

public class Cart {
    public final int MAX_NUMBERS_ORDERED = 20;
    public DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int qtyOrdered = 0;

    public void addDVD(DigitalVideoDisc dvd){
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd;
            qtyOrdered++;
            String title = dvd.getTitle();
            System.out.println("Added " + title + " to the cart.");
        } else {
            System.out.println("Cart is full.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd){
        if (qtyOrdered > 0) {
            boolean found = false;
            int i = 0;
            while (i < qtyOrdered) {
                if (itemsOrdered[i] != null && itemsOrdered[i].equals(dvd)) {
                    found = true;
                        for (int j = i; j < qtyOrdered - 1; j++) {
                        itemsOrdered[j] = itemsOrdered[j + 1];
                    }
                    itemsOrdered[qtyOrdered - 1] = null; 
                    qtyOrdered--;
    
                    System.out.println("Removed " + dvd.getTitle() + " from the Cart.");
                    return; 
                }
                i++;
            }
            if (!found) {
                System.out.println("DVD not found.");
            }
        } else {
            System.out.println("Cart is empty. Cannot remove DVD.");
        }
    }

    public float TotalCost(){
        float total = 0;
        for(int i = 0; i < qtyOrdered; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void DisplayCart(){
        for(int i = 0; i < qtyOrdered; i++){
            System.out.println("Cart: " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getDirector() + ".");
        }
    }
}
