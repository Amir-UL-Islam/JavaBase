package com.aiokleo;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class XDArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        // Read the 6x6 matrix input
        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        // Convert the list to a 2D array for easier processing
        int[][] array = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                array[i][j] = arr.get(i).get(j);
            }
        }

        // Call the function to calculate the largest hourglass sum
        int result = largestHourGlass(array);
        System.out.println(result);
    }

    public static int largestHourGlass(int[][] arr) {
        int largestHourGlass = Integer.MIN_VALUE;

        // Iterate through the 4x4 grid where hourglasses can exist
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                // Calculate the hourglass sum for the current center
                int sum = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1] // Top row
                        + arr[i][j] // Middle element
                        + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1]; // Bottom row

                // Update the largest hourglass sum
                largestHourGlass = Math.max(largestHourGlass, sum);
            }
        }
        return largestHourGlass;
    }
}
