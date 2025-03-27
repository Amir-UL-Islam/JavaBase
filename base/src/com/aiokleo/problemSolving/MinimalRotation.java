package com.aiokleo.problemSolving;

import java.util.Scanner;

public class MinimalRotation {

    public static String minimalRotation(String s) {
        int n = s.length();
        String doubled = s + s; // Concatenate the string with itself
        int[] failure = new int[2 * n]; // Failure function array
        int k = 0; // Starting index of the minimal rotation

        // Process the doubled string using Booth's Algorithm
        for (int i = 1; i < 2 * n; i++) {
            int j = failure[i - k - 1];
            while (j >= 0 && doubled.charAt(i) != doubled.charAt(k + j + 1)) {
                if (doubled.charAt(i) < doubled.charAt(k + j + 1)) {
                    k = i - j - 1; // Update the start of the minimal rotation
                }
                j = failure[j];
            }
            if (j == -1 && doubled.charAt(i) != doubled.charAt(k)) {
                if (doubled.charAt(i) < doubled.charAt(k)) {
                    k = i; // Update k when a smaller character is found
                }
                failure[i - k] = -1;
            } else {
                failure[i - k] = j + 1;
            }
        }

        // Return the minimal rotation
        return doubled.substring(k, k + n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(minimalRotation(s));
    }
}
