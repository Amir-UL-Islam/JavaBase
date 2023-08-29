package com.aiokleo.problemSolving.productOfAllExceptSelf;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        int[] answer = solution.productExceptSelf(nums);
        for (int j : answer) {
            System.out.println(j);
        }

    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int product = 1;

            int[] answer = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int left_part_product = 1;
                int right_part_product = 1;
                for (int j : nums) {
                    if (j != nums[i]) {
                        right_part_product *= j;
                    }
                }
                for (int j : nums) {
                    if (j != nums[i]) {
                        left_part_product *= j;
                    }
                }
                product = left_part_product * right_part_product;
                answer[i] = product;
            }
            return answer;
        }
    }
}
