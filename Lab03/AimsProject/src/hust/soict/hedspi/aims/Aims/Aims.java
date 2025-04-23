package hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.cart.*;

public class Aims {
    public static void main(String[] args){
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", null, 0, 18.99f);
        anOrder.addMedia(dvd3);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 29.99f);
        anOrder.addMedia(dvd4);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 22.50f);
        anOrder.addMedia(dvd5);

        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 19.99f);
        anOrder.addMedia(dvd6);

        DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 27.99f);
        anOrder.addMedia(dvd7);

        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 25.50f);
        anOrder.addMedia(dvd8);

        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 21.75f);
        anOrder.addMedia(dvd9);

        DigitalVideoDisc dvd10 = new DigitalVideoDisc("The Matrix", "Science Fiction", "Lana & Lilly Wachowski", 136, 23.99f);
        anOrder.addMedia(dvd10);

        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 20.99f);
        anOrder.addMedia(dvd11);

        DigitalVideoDisc dvd12 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 24.99f);
        anOrder.addMedia(dvd12);

        DigitalVideoDisc dvd13 = new DigitalVideoDisc("Shrek", "Animation", "Andrew Adamson", 90, 14.99f);
        anOrder.addMedia(dvd13);

        anOrder.print();
        System.out.println("Total cost is: " + anOrder.TotalCost());

        DigitalVideoDisc removeMedia1 = new DigitalVideoDisc("Shrek", "Animation", "Andrew Adamson", 90, 14.99f);
        anOrder.removeMedia(removeMedia1);
        
        DigitalVideoDisc removeMedia2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.removeMedia(removeMedia2);
        
        DigitalVideoDisc removeMedia3 = new DigitalVideoDisc("Aladdin", "Animation", null, 0, 18.99f);
        anOrder.removeMedia(removeMedia3);
        
        DigitalVideoDisc removeMedia4 = new DigitalVideoDisc("Jaws", "Thriller", "Steven Spielberg", 124, 17.99f);
        anOrder.removeMedia(removeMedia4);
        
        DigitalVideoDisc removeMedia5 = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 22.99f);
        anOrder.removeMedia(removeMedia5);

        DigitalVideoDisc removeMedia6 = new DigitalVideoDisc("Shrek", "Animation", "Andrew Adamson", 90, 14.99f);
        anOrder.removeMedia(removeMedia6);

        System.out.println("Total Cost: " + anOrder.TotalCost());
    }
}
