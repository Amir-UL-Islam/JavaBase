package com.aiokleo.problemSolving;

import java.util.Scanner;

// Approach: Iterative with Euclidean distance
// Time & Space Complexity: O(m * n)
public class CandleLightSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of test cases
        int m = scanner.nextInt();

        // Process each test case
        for (int testCase = 0; testCase < m; testCase++) {
            // Book location
            double bookX = scanner.nextDouble();
            double bookY = scanner.nextDouble();

            // Number of candles
            int n = scanner.nextInt();

            // Track if any candle can light the book
            boolean canLightBook = false;

            // Check each candle
            for (int i = 0; i < n; i++) {
                // Candle location
                double candleX = scanner.nextDouble();
                double candleY = scanner.nextDouble();

                // Calculate distance between book and candle
                double distance = calculateDistance(bookX, bookY, candleX, candleY);

                // Check if candle is within 88 meters
                if (distance <= 88.0) {
                    canLightBook = true;
                    break;
                }
            }

            // Output result for this test case
            System.out.println(canLightBook ? "light a candle" : "curse the darkness");
        }

        scanner.close();
    }

    // Method to calculate Euclidean distance
    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}