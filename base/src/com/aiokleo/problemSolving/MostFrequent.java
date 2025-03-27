package com.aiokleo.problemSolving;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent {
    public static void main(String args[]){
        System.out.println(mostFrequentEven(new int[]{0, 0, 0, 0}));

    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map with counts of even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
        }

        // Variables to track the most frequent even number and its frequency
        int mostFrequent = -1;
        int highestFrequency = 0;

        // Iterate through the frequency map to determine the result
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            // Update mostFrequent if:
            // 1. The frequency is higher than the current highestFrequency, OR
            // 2. The frequency is the same, but the number is smaller
            if (frequency > highestFrequency || (frequency == highestFrequency && number < mostFrequent)) {
                mostFrequent = number;
                highestFrequency = frequency;
            }
        }

        return mostFrequent;
    }
}
