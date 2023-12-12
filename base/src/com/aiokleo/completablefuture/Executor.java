package com.aiokleo.completablefuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor {

    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            // Submit multiple IO-bound tasks
            Future<String> result1 = executorService.submit(() -> performIOOperation("Task 1"));
            Future<String> result2 = executorService.submit(() -> performIOOperation("Task 2"));
            Future<String> result3 = executorService.submit(() -> performIOOperation("Task 3"));

            // Continue with other tasks in the main thread while IO tasks are running concurrently
            System.out.println("Main thread continues with other tasks");

            // Retrieve results when needed (this may block if the tasks are not completed)
            String resultString1 = result1.get();
            String resultString2 = result2.get();
            String resultString3 = result3.get();

            // Process the results
            System.out.println("Result 1: " + resultString1);
            System.out.println("Result 2: " + resultString2);
            System.out.println("Result 3: " + resultString3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the ExecutorService when done
            executorService.shutdown();
        }
    }

    private static String performIOOperation(String taskName) {
        // Simulate an IO-bound operation
        try {
            Thread.sleep(2000); // Simulate a long IO operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = taskName + " completed";
        return "Main thread continues with other tasks";
    }
}
