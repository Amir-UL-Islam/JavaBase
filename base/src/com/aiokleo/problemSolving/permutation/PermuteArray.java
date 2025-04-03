package com.aiokleo.problemSolving.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PermuteArray {

    static List<List<Integer>> permutation(int[] nums, List<Integer> prefix) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < nums.length; i++) {
                int[] firstArray = Arrays.copyOfRange(nums, 0, i);
                int[] secondArray = Arrays.copyOfRange(nums, i + 1, nums.length);
                int[] rem = Arrays.copyOf(firstArray, firstArray.length + secondArray.length);
                System.arraycopy(secondArray, 0, rem, firstArray.length, secondArray.length);
                List<Integer> newPrefix = new ArrayList<>(prefix);
                newPrefix.add(nums[i]);
                result.addAll(permutation(rem, newPrefix));

            }
        }
        return result;

    }

    static List<List<Integer>> permutation(int[] nums) {
        return permutation(nums, new ArrayList<>());
    }

    public static void main(String[] args) {
        List<List<Integer>> permutation = permutation(new int[]{1, 2, 3, 4});
        permutation.forEach(System.out::println);
    }
}
