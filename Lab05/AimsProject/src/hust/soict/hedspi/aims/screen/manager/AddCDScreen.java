package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;
import java.awt.*;

public class AddCDScreen extends AddItemsScreen {
    private JTextField artistField;
    private JTextField directorField;
    private JTextField lengthField;

    public AddCDScreen(Store store) {
        super(store);
        setTitle("Add CD");
        // Add artist, director, and length fields to the form panel above the add button
        JPanel formPanel = (JPanel) getContentPane().getComponent(0); // Assumes form panel is first
        formPanel.setLayout(new GridLayout(6, 1));
        formPanel.add(new JLabel("Artist:"));
        artistField = new JTextField(20);
        formPanel.add(artistField);
        formPanel.add(new JLabel("Director:"));
        directorField = new JTextField(20);
        formPanel.add(directorField);
        formPanel.add(new JLabel("Length:"));
        lengthField = new JTextField(20);
        formPanel.add(lengthField);
    }

    @Override
    protected void addMediaToStore(Store store) {
        String title = titleField.getText();
        String category = categoryField.getText();
        String artist = artistField.getText();
        String director = directorField.getText();
        int length = Integer.parseInt(lengthField.getText());
        float cost = Float.parseFloat(costField.getText());

        CompactDisc cd = new CompactDisc(title, category, director, length, cost);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD added to store!");
    }
}