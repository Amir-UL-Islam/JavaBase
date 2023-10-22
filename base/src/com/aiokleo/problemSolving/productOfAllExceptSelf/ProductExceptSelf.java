package com.aiokleo.problemSolving.productOfAllExceptSelf;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {0, 0};
        SolutionTwo solution = new SolutionTwo();
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
                for (int j : nums) {
                    if (j != nums[i]) {
                        product *= j;
                    }
                }
                answer[i] = product;
                product = 1;
            }
            return answer;
        }
    }

    static class SolutionTwo {
        public int[] productExceptSelf(int[] nums) {
            int prefixProduct = 1;
            int suffixProduct = 1;
            int numsLength = nums.length;
            int[] result = new int[numsLength];
            for (int i = 0; i < numsLength; i++) {
                result[i] = prefixProduct;
                prefixProduct *= nums[i];
            }
            for (int i = numsLength - 1; i >= 0; i--) {
                result[i] *= suffixProduct;
                suffixProduct *= nums[i];
            }
            return result;
        }
    }
}
