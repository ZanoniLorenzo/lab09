package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.util.List;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My simple java graphical interface");
    private final Controller controller = new SimpleController();

    /**
     * Creates a new SimpleGUI, setting up the whole view.
     */
    public SimpleGUI() {
        final JTextField field = new JTextField("catullo");
        final JTextArea textArea = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton show = new JButton("Show history");
        final JPanel panel = new JPanel();
        final JPanel buttonPanel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(field, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        buttonPanel.add(show, BorderLayout.EAST);
        buttonPanel.add(print, BorderLayout.WEST);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(3);
        frame.setContentPane(panel);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNext(field.getText());
                controller.printCurrent();
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final List<String> history = controller.getHistory();
                for (final String s : history) {
                    textArea.append(s + "\n");
                }
            }
        });
    }

    /**
     * Displays the GUI.
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * main method, starts the graphical application.
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
