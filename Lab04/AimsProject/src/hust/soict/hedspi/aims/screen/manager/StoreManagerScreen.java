package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame{
    private Store store;
    public StoreManagerScreen(Store store){
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout()); 
        cp.add(createNorth(), BorderLayout.NORTH); 
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768); 
        setLocationRelativeTo (null);
        setVisible(true);
    }
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar() {
        JMenu options = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e->{
            new StoreManagerScreen(this.store);
            dispose();
        });

        JMenu updateStore = new JMenu("Update Store");

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> new AddCDScreen(store));
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> new AddBookScreen(store));
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> new AddDVDScreen(store));
        updateStore.add(addBook);
        updateStore.add(addCD);
        updateStore.add(addDVD);

        options.add(viewStore);
        options.add(updateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(options);
        return menuBar;
    }
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title= new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50)); title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea (new Dimension (10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea (new Dimension(10, 10)));
        return header;
    }
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout (3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {

            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }
}
