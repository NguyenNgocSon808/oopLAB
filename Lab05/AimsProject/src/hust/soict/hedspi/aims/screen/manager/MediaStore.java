package hust.soict.hedspi.aims.screen.manager;

import javax.swing.JPanel;
import hust.soict.hedspi.aims.media.*;
import java.awt.*;
import javax.swing.*;

public class MediaStore extends JPanel{
    private Media media;
    public MediaStore (Media media) {
        this.media = media;
        this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container= new JPanel();
        container.setLayout(new FlowLayout (FlowLayout.CENTER));

        if(media instanceof Playable) {
            JButton playButton = new JButton("Play"); 

            playButton.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    JOptionPane.showMessageDialog(null, "Playing: " + media.getTitle(), "Play", JOptionPane.INFORMATION_MESSAGE);
                } catch (hust.soict.hedspi.aims.exception.PlayerException ex) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error: ").append(ex.getMessage()).append("\n");
                    sb.append(ex.toString()).append("\n");
                    java.io.StringWriter sw = new java.io.StringWriter();
                    ex.printStackTrace(new java.io.PrintWriter(sw));
                    sb.append(sw.toString());
                    JOptionPane.showMessageDialog(null, sb.toString(), "Play Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}