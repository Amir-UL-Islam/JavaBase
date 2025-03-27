package com.aiokleo.problemSolving;

import java.util.*;
// Time Complexity: O(m * n)
public class ClockTimeSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of test cases
        int T = scanner.nextInt();

        // Process each test case
        for (int t = 0; t < T; t++) {
            // Read N and M
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            // Arrays to store initial times and movements
            int[] initialTimes = new int[M];
            int[] movements = new int[M];

            // Read initial times
            for (int i = 0; i < M; i++) {
                initialTimes[i] = scanner.nextInt();
            }

            // Read movements
            for (int i = 0; i < M; i++) {
                movements[i] = scanner.nextInt();
            }

            // Solve and print result
            int[] result = findMostVisitedTime(N, M, initialTimes, movements);
            System.out.println(result[0] + " " + result[1]);
        }

        scanner.close();
    }

    public static int[] findMostVisitedTime(int N, int M, int[] initialTimes, int[] movements) {
        // Create a frequency map to count time visits
        Map<Integer, Integer> timeFrequency = new HashMap<>();

        // Process each student's time change
        for (int i = 0; i < M; i++) {
            // Calculate new time after movement
            int newTime = ((initialTimes[i] + movements[i]) % N + N) % N;

            // If newTime is 0, change it to N
            newTime = newTime == 0 ? N : newTime;

            // Increment frequency of this time
            timeFrequency.put(newTime, timeFrequency.getOrDefault(newTime, 0) + 1);
        }

        // Find the most visited time
        int mostVisitedTime = 0;
        int maxVisits = 0;

        for (Map.Entry<Integer, Integer> entry : timeFrequency.entrySet()) {
            if (entry.getValue() > maxVisits ||
                    (entry.getValue() == maxVisits && entry.getKey() < mostVisitedTime)) {
                mostVisitedTime = entry.getKey();
                maxVisits = entry.getValue();
            }
        }

        return new int[]{mostVisitedTime, maxVisits};
    }
}