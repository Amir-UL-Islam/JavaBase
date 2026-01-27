package com.aiokleo.threads;

import java.util.concurrent.TimeUnit;

public class Tools {
    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadOne.setName("Thread #1");
        threadOne.start();

        Thread threadTwo = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("Running");
            }
        });

        threadTwo.setName("Thread #2");
        threadTwo.start();

        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadTwo.interrupt();
    }
}
