package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My second java graphical interface");
    private final Controller controller = new Controller();

    /**
     * 
     */
    public SimpleGUIWithFileChooser() {
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");
        final JPanel panel = new JPanel();
        final JPanel internalPanel = new JPanel();
        final JTextField filePathField = new JTextField(controller.getFilePath());
        final JButton browseButton = new JButton("Browse...");
        internalPanel.setLayout(new BorderLayout());
        internalPanel.add(filePathField, BorderLayout.CENTER);
        internalPanel.add(browseButton, BorderLayout.EAST);
        panel.setLayout(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        panel.add(internalPanel, BorderLayout.NORTH);
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
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int returnValue;
                returnValue = fileChooser.showSaveDialog(browseButton);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    final File selectedFile = fileChooser.getSelectedFile();
                    controller.setFilePath(selectedFile);
                    filePathField.setText(controller.getFilePath());
                } else if (returnValue == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Error selecting file", "Error", JOptionPane.ERROR_MESSAGE);
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
        new SimpleGUIWithFileChooser().display();
    }
}
