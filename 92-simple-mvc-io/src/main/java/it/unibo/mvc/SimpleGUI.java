package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My first java graphical interface");
    private final Controller controller = new Controller();

    /**
     * Creates a new SimpleGUI, setting up the whole view.
     */
    public SimpleGUI() {
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(3);
        frame.setContentPane(panel);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.write(textArea.getText());
                    JOptionPane.showMessageDialog(frame, "File saved at: " + controller.getFilePath());
                } catch (final IllegalStateException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
                }
            }
        });
    }

    /**
     * main method, starts the graphical application.
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        final SimpleGUI gui = new SimpleGUI();
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        gui.frame.setSize(sw / PROPORTION, sh / PROPORTION);
        gui.frame.setLocationByPlatform(true);
        gui.frame.setVisible(true);
    }
}
