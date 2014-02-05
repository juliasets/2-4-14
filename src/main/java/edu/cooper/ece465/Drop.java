package edu.cooper.ece465;

import java.util.*;

public class Drop {
    // Messages sent from producer
    // to consumer.
    private List messages;

    public Drop () {
        messages = new ArrayList<Integer>();
    }

    public synchronized int take() {
        // Wait until message is
        // available.
        while (messages.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        int message = (int) messages.remove(0);
        if (message != -1) {
            // Put back.
            messages.add(-1);
        }
        // Notify producer that
        // status has changed.
        notifyAll();
        return message;
    }

    public synchronized void put(int message) {
        // Store message.
        messages.add(message);
        // Notify consumer that status
        // has changed.
        notifyAll();
    }
}
