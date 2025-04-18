package hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.disc.*;
import hust.soict.hedspi.aims.cart.*;

public class Aims {
    public static void main(String[] args){
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", null, 0, 18.99f);
        anOrder.addDVD(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 29.99f);
        anOrder.addDVD(dvd4);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 22.50f);
        anOrder.addDVD(dvd5);

        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 19.99f);
        anOrder.addDVD(dvd6);

        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 27.99f);
        anOrder.addDVD(dvd7);

        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 25.50f);
        anOrder.addDVD(dvd8);

        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 21.75f);
        anOrder.addDVD(dvd9);

        DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Matrix", "Science Fiction", "Lana & Lilly Wachowski", 136, 23.99f);
        anOrder.addDVD(dvd10);

        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 20.99f);
        anOrder.addDVD(dvd11);

        DigitalVideoDisc dvd12 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 24.99f);
        anOrder.addDVD(dvd12);

        DigitalVideoDisc dvd13 = new DigitalVideoDisc("Shrek", "Animation", "Andrew Adamson", 90, 14.99f);
        anOrder.addDVD(dvd13);

        anOrder.DisplayCart();
        System.out.println("Total cost is: " + anOrder.TotalCost());

        DigitalVideoDisc removeDVD1 = new DigitalVideoDisc("Shrek", "Animation", "Andrew Adamson", 90, 14.99f);
        anOrder.removeDVD(removeDVD1);
        
        DigitalVideoDisc removeDVD2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.removeDVD(removeDVD2);
        
        DigitalVideoDisc removeDVD3 = new DigitalVideoDisc("Aladdin", "Animation", null, 0, 18.99f);
        anOrder.removeDVD(removeDVD3);
        
        DigitalVideoDisc removeDVD4 = new DigitalVideoDisc("Jaws", "Thriller", "Steven Spielberg", 124, 17.99f);
        anOrder.removeDVD(removeDVD4);
        
        DigitalVideoDisc removeDVD5 = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 22.99f);
        anOrder.removeDVD(removeDVD5);

        DigitalVideoDisc removeDVD6 = new DigitalVideoDisc("Shrek", "Animation", "Andrew Adamson", 90, 14.99f);
        anOrder.removeDVD(removeDVD6);

        anOrder.DisplayCart();
        System.out.println("Total Cost: " + anOrder.TotalCost());
    }
}
