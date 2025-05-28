package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class TestViewStoreScreen extends Application {
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Use classpath-relative path for FXML
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, null);
        fxmlLoader.setController(viewStoreController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public static void main(String[] args) {
        store = new Store();
        initializeStore();
        launch(args);
    }
    private static void initializeStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    	DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
    	DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 21.50f);
    	DigitalVideoDisc dvd4 = new DigitalVideoDisc("Titanic", "Drama", "James Cameron", 195, 17.00f);
    	DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avengers: Endgame", "Action", "Anthony Russo", 181, 22.75f);

    	// Books
    	Book book1 = new Book("Aladin", "Fantasy", 18.99f);
    	book1.addAuthor("John Smith");

	    Book book2 = new Book("Harry Potter", "Fantasy", 29.99f);
	    book2.addAuthor("J.K. Rowling");

	    Book book3 = new Book("1984", "Dystopian", 15.00f);
	    book3.addAuthor("George Orwell");

	    Book book4 = new Book("The Hobbit", "Fantasy", 25.00f);
	    book4.addAuthor("J.R.R. Tolkien");

	    Book book5 = new Book("To Kill a Mockingbird", "Classic", 12.50f);
	    book5.addAuthor("Harper Lee");

	    // CDs
	    CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Quincy Jones", "Michael Jackson", 42, 15.99f);
	    cd1.addTrack(new Track("Thriller", 357));
	    cd1.addTrack(new Track("Beat It", 258));

	    CompactDisc cd2 = new CompactDisc("Divide", "Pop", "Ed Sheeran", "Ed Sheeran", 59, 13.99f);
	    cd2.addTrack(new Track("Shape of You", 233));
	    cd2.addTrack(new Track("Perfect", 263));

	    CompactDisc cd3 = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 47, 18.00f);
	    cd3.addTrack(new Track("Come Together", 259));
	    cd3.addTrack(new Track("Something", 182));

	    // Adding to store
	    try {
	        store.addMedia(dvd1);
	        store.addMedia(dvd2);
	        store.addMedia(dvd3);
	        store.addMedia(dvd4);
	        store.addMedia(dvd5);

	        store.addMedia(book1);
	        store.addMedia(book2);
	        store.addMedia(book3);
	        store.addMedia(book4);
	        store.addMedia(book5);

	        store.addMedia(cd1);
	        store.addMedia(cd2);
	        store.addMedia(cd3);
	    } catch (Exception e) {
	        System.err.println("Exception occurred while adding media to store:");
	        System.err.println("Message: " + e.getMessage());
	        System.err.println("Exception: " + e.toString());
	        e.printStackTrace();
	    }
    }
}
