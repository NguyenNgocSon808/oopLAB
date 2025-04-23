package hust.soict.hedspi.aims.cart;

import java.util.Scanner;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        //Create a new cart
        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);
        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
        cart.addMedia(dvd2);
        Book dvd3 = new Book("Aladin", "Animation", 18.99f); 
        cart.addMedia(dvd3);

        //Test the print method
        cart.print();

        //To-do: Test the search methods here
        int choice = 1;
        while(true){
            System.out.println("Search by:\n0. Exit\n1. ID\n2. title");
            choice = sc.nextInt();
            if(choice == 0 ) break;
            else if(choice == 1){
                int id = sc.nextInt();
                cart.SearchDVD(id);
            }
            else if(choice == 2){
                String title = sc.nextLine();
                cart.SearchDVD(title);
            }
            else {System.out.println("Error. Please re-enter.");}
        }
        sc.close();
    }
}
