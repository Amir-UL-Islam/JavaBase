package com.aiokleo.completablefuture;

import java.util.concurrent.CompletableFuture;

public class Features {
    public static void main(String[] args) throws InterruptedException {
        Thread wait = new Thread();
        Thread.sleep(10000);
        wait.start();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, world!";
        });

        future.thenAccept(System.out::println);
    }


}
