package it.unibo.mvc;

import java.util.List;

/**
 * a controller interface.
 */
public interface Controller {
    /**
     * Sets the next String to be printed. if null, throws an exception.
     * 
     * @param data The string to be set
     */
    void setNext(String data);

    /**
     * Gets the next String to be printed.
     * 
     * @return the String to be printed
     */
    String getNext();

    /**
     * Gets the history of all printed strings.
     * 
     * @return the history of printed Strings
     */
    List<String> getHistory();

    /**
     * Prints the current string.
     */
    void printCurrent();
}
