package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File file;

    /**
     * Constructs a new controller with a default file path "output.txt".
     */
    public Controller() {
        this.file = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt");
    }

    /**
     * Sets the file path in to a new file, if new file is null it does nothing.
     * 
     * @param newFile the new file path
     */
    public void setFilePath(final File newFile) {
        if (newFile != null) {
            this.file = newFile;
        }
    }

    /**
     * Gets the current file path.
     * 
     * @return the current file path
     */
    public String getFilePath() {
        return file.getPath();
    }

    /**
     * Writes data of String type to the file. it may throw a FileNotFound exception.
     * 
     * @param data the data to write
     */
    public void write(final String data) {
        try (PrintStream ps = new PrintStream(this.file)) {
            ps.print(data);
        } catch (final FileNotFoundException e) {
            throw new IllegalStateException("File not found", e);
        }
    }
}
