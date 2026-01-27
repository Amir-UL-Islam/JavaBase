package com.aiokleo.problemSolving;

import java.util.*;

public class RoomAllocationLinearTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of guests
        int N = scanner.nextInt();

        // Arrays to track events
        int[] starts = new int[N];
        int[] ends = new int[N];

        // Read guest times
        for (int i = 0; i < N; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }

        // Find maximum time to create count array
        int maxTime = Arrays.stream(ends).max().getAsInt();

        // Array to count simultaneous guests
        int[] timeline = new int[maxTime + 2];

        // Mark start and end of intervals
        for (int i = 0; i < N; i++) {
            timeline[starts[i]]++;   // Guest arrives
            timeline[ends[i] + 1]--; // Guest departs
        }

        // Compute maximum simultaneous guests
        int maxRooms = 0;
        int currentRooms = 0;

        for (int i = 1; i <= maxTime; i++) {
            currentRooms += timeline[i];
            maxRooms = Math.max(maxRooms, currentRooms);
        }

        System.out.println(maxRooms);
        scanner.close();
    }
}