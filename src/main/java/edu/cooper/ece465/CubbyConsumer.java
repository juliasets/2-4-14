package edu.cooper.ece465;

public class CubbyConsumer extends Thread {
    private CubbyHole cubbyhole;
    private int number;

    public CubbyConsumer(CubbyHole c, int number) {
        cubbyhole = c;
        this.number = number;
    }
 
    public void run() {
        int value = 0;
        int count = 0;
        for (;;) {
            value = cubbyhole.get();
            if (value == -1) break;
            ++count;
            System.out.println("Consumer #" + this.number
                               + " got: " + value);
        }
        System.out.println("Consumer #" + this.number +
            " finished processing: " + count);
    }
}
