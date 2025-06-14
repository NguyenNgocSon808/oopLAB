package hust.soict.hedspi.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import hust.soict.hedspi.aims.media.Media;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {

	private Media media;
	public MediaStore(Media media) {
		this.media = media;
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Now Playing");
                    dialog.setSize(300, 150);
                    dialog.setLocationRelativeTo(null);
                    JTextArea textArea = new JTextArea("Now playing: " + media.getTitle());
                    textArea.setEditable(false);
                    dialog.add(textArea);
                    dialog.setVisible(true);
                } catch (hust.soict.hedspi.aims.exception.PlayerException ex) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Play Error");
                    dialog.setSize(400, 250);
                    dialog.setLocationRelativeTo(null);
                    JTextArea textArea = new JTextArea(
                        "Error: " + ex.getMessage() + "\n" +
                        ex.toString() + "\n" +
                        getStackTraceString(ex)
                    );
                    textArea.setEditable(false);
                    dialog.add(textArea);
                    dialog.setVisible(true);
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
	
    private static String getStackTraceString(Throwable t) {
        java.io.StringWriter sw = new java.io.StringWriter();
        java.io.PrintWriter pw = new java.io.PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
	
}
