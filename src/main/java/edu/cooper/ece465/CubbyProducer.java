package edu.cooper.ece465;

public class CubbyProducer extends Thread {
    private CubbyHole cubbyhole;
    private int number;
 
    public CubbyProducer(CubbyHole c, int number) {
        c.register();
        cubbyhole = c;
        this.number = number;
    }
 
    public void run() {
        int count = 0;
        for (int i = 0; i < ProducerConsumerTest.PROD_SIZE; i++) {
            cubbyhole.put(i); ++count;
            System.out.println("Producer #" + this.number
                               + " put: " + i);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
        }
        cubbyhole.put(-1);
        System.out.println("Producer #" + this.number +
            " finished processing: " + count);
    }
}
