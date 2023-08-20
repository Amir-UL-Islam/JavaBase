package com.aiokleo.problemSolving.twoSum;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
//        SolutionTowPointerApproach solutionTowPointerApproach = new SolutionTowPointerApproach();
//        SolutionBrutForceApproach solutionBrutForceApproach = new SolutionBrutForceApproach();
//        System.out.println(solutionTowPointerApproach.isPalindrome("talat"));
//        System.out.println(solutionBrutForceApproach.isPalindrome("talat"));


        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] indexs = twoSumSolution.twoSum(nums, target);
        System.out.println(indexs[0] + " " + indexs[1]);
    }

//    //     Brut-Force Approach
//    static class SolutionBrutForceApproach {
//        public boolean isPalindrome(String s) {
//            String reversedString = "";
//            char ch;
//            String new_s = s.replaceAll("[^a-zA-Z\\d:\\u00C0-\\u00FF]", "").trim().replace(":", "").toLowerCase();
//            for (int i = 0; i < new_s.length(); i++) {
//                ch = new_s.charAt(i);
//                reversedString = ch + reversedString;
//            }
//            if (reversedString.equals(new_s)) {
//                return true;
//            }
//            return false;
//
//        }
//    }
//
////Tow-Pointer Approach
////The advantage is the space complexity is O(1) the constant
//
//    static class SolutionTowPointerApproach {
//        public boolean isPalindrome(String s) {
//            if (s == null || s.length() == 0) {
//                return true; // An empty string or null is considered a palindrome
//            }
//
//            int left = 0;
//            int right = s.length() - 1;
//
//            while (left < right) {
//                char leftChar = Character.toLowerCase(s.charAt(left));
//                char rightChar = Character.toLowerCase(s.charAt(right));
//
////                This is String "23erewr342"
//                if (!Character.isLetterOrDigit(leftChar)) {
//                    left++;
//                } else if (!Character.isLetterOrDigit(rightChar)) {
//                    right--;
//                } else if (leftChar != rightChar) {
//                    return false;
//                } else {
//                    left++;
//                    right--;
//                }
//            }
//
//            return true;
//        }
//    }


    static class TwoSumSolution {
        //        public int[] twoSum(int[] nums, int target) {
//            int left = 0;
//            int right = nums.length - 1;
//            int[] indexs = new int[2];
//
//            while (left < right) {
//                int sum = nums[left] + nums[right];
//                if (sum == target) {
//                    indexs[0] = left;
//                    indexs[1] = right;
//                    break;
//                } else if (sum < target) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//            return indexs;
//        }
//
//    }
        public int[] twoSum(int[] nums, int target) {

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
}
