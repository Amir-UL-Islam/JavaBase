package com.aiokleo.threads;

import javax.swing.plaf.IconUIResource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ThreadTermination implements Runnable {
    private boolean runningStatus = true;

    @Override
    public void run() {

        while (isRunningStatus()) {
            System.out.println("Inside: " + Thread.currentThread().getName() + "Thread at " + printCurrentTime());
            sleepForOneSecond();

            if (Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName() + " is Intercepted");
            }
        }
    }

    private static void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sleepForTowSecond() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String printCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:s a");
        return LocalDateTime.now().format(formatter);
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadTermination threadTermination = new ThreadTermination();
        Thread threadTracker = new Thread(threadTermination);
        threadTracker.setName("Secondary ");
        threadTracker.start();
        sleepForOneSecond();
        threadTracker.interrupt();

        int counter = 0;
        while (threadTracker.isAlive()) {
            System.out.println("Inside: " + Thread.currentThread().getName() + "Thread at " + printCurrentTime());
            sleepForOneSecond();

            if (counter == 5) {
                threadTermination.setRunningStatus(false);
            }
            System.out.println("Counter Progressed at: " + counter);
            counter++;


        }

    }
    public boolean isRunningStatus() {
        return runningStatus;
    }

    public void setRunningStatus(boolean runningStatus) {
        this.runningStatus = runningStatus;
    }

}
