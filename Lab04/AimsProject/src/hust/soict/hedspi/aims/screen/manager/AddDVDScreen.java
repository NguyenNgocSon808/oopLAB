package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;
import java.awt.*;

public class AddDVDScreen extends AddItemsScreen {
    public AddDVDScreen(Store store) {
        super(store);
        setTitle("Add DVD");
    }

    @Override
    protected void addMediaToStore(Store store) {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD added to store!");
    }
}
