package com.aiokleo.problemSolving.hasDuplicates;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 34, 35 };
//Version    TimeComplexity SpaceComplexity
//Version #1     O(N2)             O(1)
//Version #2     O(N)              O(N)
//Version #3     O(N log N)        O(log N)
        System.out.println(hasDuplicate(array));
        System.out.println(hasDuplicateII(array));
        System.out.println(hasDuplicateIII(array));
    }

    public static boolean hasDuplicate(int[] array) {
        int length = array.length; // Should be ignored at time of Analysis
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasDuplicateII(int[] array) {
        HashSet<Integer> newArray = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!newArray.contains(array[i])) {
                newArray.add(array[i]);
            } else
                return true;
        }
        return false;
    }

    public static boolean hasDuplicateIII(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) { // as we comparing (i == i + 1) so we need to hold last element for
                                                     // avoiding array size out of range error
            if (array[i] == array[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
