package com.aiokleo.problemSolving.twoSum;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] indexs = twoSumII(nums, target);
        System.out.println(indexs[0] + " " + indexs[1]);
    }


    public static int[] twoSumII(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] indexs = new int[2];

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                indexs[0] = left;
                indexs[1] = right;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return indexs;
    }


    public static int[] twoSum(int[] nums, int target) {

        int[] copyOfNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyOfNums);

        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int sum = copyOfNums[left] + copyOfNums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                break;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == copyOfNums[left]) {
                result[0] = nums[k];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == copyOfNums[right]) {
                result[1] = i;
            }
        }
        return result;
    }
}
