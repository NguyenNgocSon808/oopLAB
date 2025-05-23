package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;
import java.awt.*;

public class AddBookScreen extends AddItemsScreen {
    public AddBookScreen(Store store) {
        super(store);
        setTitle("Add Book");
        // Add author field to the form panel above the add button
        JPanel formPanel = (JPanel) getContentPane().getComponent(0); // Assumes form panel is first
        formPanel.setLayout(new GridLayout(4, 1));
        formPanel.add(new JLabel("Author:"));
        JTextField authorField = new JTextField(20);
        formPanel.add(authorField);
    }

    @Override
    protected void addMediaToStore(Store store) {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        // Author is not used in Book constructor by default, but field is added for extensibility
        Book book = new Book(title, category, cost);
        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added to store!");
    }
}