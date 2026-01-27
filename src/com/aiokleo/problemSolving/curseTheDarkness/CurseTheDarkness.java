package com.aiokleo.problemSolving.curseTheDarkness;

import java.util.Scanner;

public class CurseTheDarkness {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of lines: ");
        int[][] bookPositionInCoordinate = new int[][]{};
        int numberOfCandles = 0;
        int[][] candlePositionInCoordinate = new int[][]{};
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < n; i++) {
            System.out.print("Enter line " + (i + 1) + " (comma-separated values): ");
            String line = scanner.nextLine();
            boolean validateLine = isValidateLine(line);
            if (!validateLine) {
                n++;
            }

            if (i == 0){
                String[] split = line.split(",");
                if (split.length != 2) {
                    System.out.println("Invalid input");
                    n++;
                }
                int[] bookPosition = new int[2];
                for (String s : split) {
                    bookPosition[0] = Integer.parseInt(s.trim());
                    bookPosition[1] = Integer.parseInt(s.trim());
                }
                bookPositionInCoordinate[0] = bookPosition;
            }



        }
        scanner.close();
    }

    public static boolean isValidateLine(String line) {
        String[] values = line.split(",");
        if (values.length > 2) {
            return false;
        }
        for (String value : values) {
            value = value.trim(); // Remove leading/trailing spaces
            if (!isValid(value)) {
                System.out.println("Invalid input: " + value + " in line: " + line);
                return false;
            }
        }
        System.out.println("Valid line: " + line);
        return true;
    }

    public static boolean isValid(String value) {
        // Add your validation logic here
        // Example: Check if the value is an integer
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

