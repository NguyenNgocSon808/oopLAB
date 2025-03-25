package Aims;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int qtyOrdered;
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
        if(qtyOrdered > 0){
            boolean found = false;
            int i = 0;
            while (!found) {
                if (itemsOrdered[i].equals(dvd)) {
                    found = true;
                    for(int j = i; j < qtyOrdered - 1; j++){
                        itemsOrdered[j] = itemsOrdered[j+1];
                    }
                    itemsOrdered[qtyOrdered-1] = null;
                    qtyOrdered--;
                    System.out.println("Removed " + dvd.getTitle() + " from the Cart.");
                    break;
                } else {
                    i++;
                    if (i == MAX_NUMBERS_ORDERED) {
                        System.out.println("DVD not found.");
                        break;
                    }
                }
            }
        } else{
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
}
