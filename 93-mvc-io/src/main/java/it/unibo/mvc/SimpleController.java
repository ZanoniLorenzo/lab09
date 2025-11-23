package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * A controller that manages I/O operations with strings.
 */
public final class SimpleController implements Controller {
    private final List<String> history = new LinkedList<>();
    private String next;

    /**
     * A method to set the next string to print.
     * 
     * @param data the string to set as next
     */
    @Override
    public void setNext(final String data) {
        if (data != null) {
            this.next = data;
        } else {
            throw new IllegalArgumentException("Data cannot be null");
        }
    }

    /**
     * A method to get the next string to print.
     * 
     * @return the next string
     */
    @Override
    public String getNext() {
        return this.next;
    }

    /**
     * A method to get the history of printed strings.
     * 
     * @return the history
     */
    @Override
    public List<String> getHistory() {
        return history;
    }

    /**
     * A method to get the current string to print.
     */
    @Override
    public void printCurrent() {
        try {
            System.out.println(this.next); // NOPMD
            this.history.add(this.next);
        } catch (final IllegalStateException e) {
            throw new IllegalStateException("No data to print", e);
        }
    }
}
