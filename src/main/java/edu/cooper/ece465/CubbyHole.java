package edu.cooper.ece465;

public class CubbyHole {
    private int contents;
    private boolean available = false;
    private int nproducers = 0;

    public void register() {
        ++nproducers;
    }

    public synchronized int get() {
        while (available == false && nproducers > 0) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        if (available == false && nproducers == 0) return -1;
        available = false;
        notifyAll();
        return contents;
    }
 
    public synchronized void put(int value) {
        if (value == -1) {
            --nproducers;
            notifyAll();
            return;
        }
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}
