package com.aiokleo.problemSolving.containMostWater;

import static java.lang.Math.*;

public class ContainMostWater {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(nums));
    }

    static class Solution {
        public int maxArea(int[] height) {
            int result = 0;
            for (int k : height) {
                for (int j = 1; j < height.length; j++) {
                    int area = (height[j] - k) * min(height[j], k);
                    result = max(area, result);
                }
            }
            return result;
        }
    }
}
