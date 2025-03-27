package com.aiokleo.threads.multithreadissues;

public class HelloCollapsed {
    static boolean s = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (s) {

            }
            System.out.println("Hellow");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            s = true;
            System.out.println("Hi");
        });

        t2.start();
    }

}
