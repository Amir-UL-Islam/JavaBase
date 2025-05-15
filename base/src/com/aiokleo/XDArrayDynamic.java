package com.aiokleo;

import java.io.*;
import java.util.*;

public class XDArrayDynamic {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read input dimensions dynamically
        String[] dimensions = bufferedReader.readLine().trim().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        // Read the matrix
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        bufferedReader.close();

        // Calculate and print the largest hourglass sum
        int result = findLargestHourglassSum(arr, n, m);
        System.out.println(result);
    }

    public static int findLargestHourglassSum(int[][] arr, int n, int m) {
        int maxSum = Integer.MIN_VALUE;

        // Traverse only where hourglasses can fit
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                // Compute the hourglass sum dynamically
                int sum = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1]  // Top row
                        + arr[i][j]                                           // Middle element
                        + arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1]; // Bottom row

                // Update the maximum sum
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}

