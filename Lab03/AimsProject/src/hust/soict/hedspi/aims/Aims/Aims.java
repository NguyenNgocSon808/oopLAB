package hust.soict.hedspi.aims.Aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeStore();
        showMenu();
    }

    private static void initializeStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        Book book1 = new Book("Aladin", "Animation", 18.99f);
        book1.addAuthor("John Smith");

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Quincy Jones", "Michael Jackson", 42, 15.99f);
        Track track1 = new Track("Thriller", 357);
        Track track2 = new Track("Beat It", 258);
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);
    }

    public static void showMenu() {
        while (true) {
            printMenuHeader("AIMS");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            printMenuFooter();

            int choice = getChoice(0, 3);
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }

    private static void viewStore() {
        store.print();
        storeMenu();
    }

    private static void storeMenu() {
        while (true) {
            printMenuHeader("STORE");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            printMenuFooter();

            int choice = getChoice(0, 4);
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void mediaDetailsMenu(Media media) {
        while (true) {
            printMenuHeader("MEDIA DETAILS");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            printMenuFooter();

            int choice = getChoice(0, media instanceof Playable ? 2 : 1);
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    }
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void addMediaToCart() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void playMedia() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or not playable.");
        }
    }

    private static void updateStore() {
        while (true) {
            printMenuHeader("UPDATE STORE");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            printMenuFooter();

            int choice = getChoice(0, 2);
            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void addMediaToStore() {
        printMenuHeader("ADD MEDIA");
        System.out.println("1. Add DVD");
        System.out.println("2. Add Book");
        System.out.println("3. Add CD");
        System.out.println("0. Back");
        printMenuFooter();

        int type = getChoice(0, 3);
        if (type == 0) return;

        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume newline

        switch (type) {
            case 1: // DVD
                System.out.print("Director: ");
                String director = scanner.nextLine();
                System.out.print("Length (minutes): ");
                int length = scanner.nextInt();
                scanner.nextLine();

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);
                break;
            case 2: // Book
                Book book = new Book(title, category, cost);
                System.out.print("Number of authors: ");
                int numAuthors = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < numAuthors; i++) {
                    System.out.print("Author " + (i+1) + ": ");
                    book.addAuthor(scanner.nextLine());
                }
                store.addMedia(book);
                break;
            case 3: // CD
                System.out.print("Artist: ");
                String artist = scanner.nextLine();
                System.out.print("Director: ");
                String cdDirector = scanner.nextLine();
                System.out.print("Length: ");
                int leng = scanner.nextInt();

                CompactDisc cd = new CompactDisc(title, category, cdDirector, artist, leng, cost);

                System.out.print("Number of tracks: ");
                int numTracks = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < numTracks; i++) {
                    System.out.print("Track " + (i+1) + " title: ");
                    String trackTitle = scanner.nextLine();
                    System.out.print("Track " + (i+1) + " length (seconds): ");
                    int trackLength = scanner.nextInt();
                    scanner.nextLine();
                    cd.addTrack(new Track(trackTitle, trackLength));
                }
                store.addMedia(cd);
                break;
        }
        System.out.println("Media added to store.");
    }

    private static void removeMediaFromStore() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            store.removeMedia(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void seeCurrentCart() {
        cart.print();
        cartMenu();
    }

    private static void cartMenu() {
        while (true) {
            printMenuHeader("CART");
            System.out.println("1. Filter media");
            System.out.println("2. Sort media");
            System.out.println("3. Remove media");
            System.out.println("4. Play media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            printMenuFooter();

            int choice = getChoice(0, 5);
            switch (choice) {
                case 1:
                    filterMedia();
                    break;
                case 2:
                    sortMedia();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    placeOrder();
                    return;
                case 0:
                    return;
            }
        }
    }

    private static void filterMedia() {
        printMenuHeader("FILTER MEDIA");
        System.out.println("1. By ID");
        System.out.println("2. By Title");
        System.out.println("0. Back");
        printMenuFooter();

        int choice = getChoice(0, 2);
        if (choice == 0) return;

        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            boolean found = false;
            cart.searchByID(id);
            if (!found) System.out.println("No media found with ID: " + id);
        } else {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            boolean found = false;
            cart.searchByTitle(title);
            if (!found) System.out.println("No media found with title: " + title);
        }
    }

    private static void sortMedia() {
        printMenuHeader("SORT MEDIA");
        System.out.println("1. By Title");
        System.out.println("2. By Cost");
        System.out.println("0. Back");
        printMenuFooter();

        int choice = getChoice(0, 2);
        if (choice == 0) return;

        if (choice == 1) {
            cart.sortByTitle();
        } else {
            cart.sortByCost();
        }
        cart.print();
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);

        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    private static void playMediaInCart() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or not playable.");
        }
    }

    private static void placeOrder() {
        System.out.println("Order created. Your cart will be emptied.");
        cart.emptyCart();
    }

    // Helper methods
    private static void printMenuHeader(String title) {
        System.out.println();
        System.out.println(title.toUpperCase() + ":");
        System.out.println("--------------------------------");
    }

    private static void printMenuFooter() {
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    private static int getChoice(int min, int max) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } catch (Exception e) {
                scanner.nextLine(); // Clear invalid input
            }
            System.out.print("Invalid choice. Please enter a number between " + min + " and " + max + ": ");
        }
    }
}
