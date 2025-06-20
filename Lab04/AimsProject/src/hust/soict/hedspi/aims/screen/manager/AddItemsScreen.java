package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemsScreen extends JFrame {
    private Store store;

    protected JTextField titleField = new JTextField(20);
    protected JTextField categoryField = new JTextField(20);
    protected JTextField costField = new JTextField(20);

    public AddItemsScreen(Store store) {
        this.store = store;
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createFormPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addMediaToStore(store));
        panel.add(addButton);
        return panel;
    }

    protected abstract void addMediaToStore(Store store);
}
