package edu.cooper.ece465;

import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();

        for (int i = 0;
             i < 5;
             i++) {
            drop.put(i);
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {}
        }
        drop.put(-1);
    }
}
