package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;
import java.awt.*;

public class AddCDScreen extends AddItemsScreen {
    public AddCDScreen(Store store) {
        super(store);
        setTitle("Add CD");
    }

    @Override
    protected void addMediaToStore(Store store) {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        CompactDisc cd = new CompactDisc(title, category, cost);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD added to store!");
    }
}