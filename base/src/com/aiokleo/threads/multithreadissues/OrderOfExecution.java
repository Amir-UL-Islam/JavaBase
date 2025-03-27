package com.aiokleo.threads.multithreadissues;

public class OrderOfExecution {
    static int s1 = 0;
    static int s2 = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int l1 = s1;
            s2 = 2;
            System.out.println("Thread1: " + l1);
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            int l2 = s2;
            s1 = 1;
            System.out.println("Thread2: " + l2);

        });
        t2.start();
    }
}
