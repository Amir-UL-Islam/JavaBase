package com.aiokleo.problemSolving.bulbSwitcher;

public class Solution {
    public static void main(String[] args) {
        System.out.println(bulbSwitch(10));
    }

    public static int bulbSwitch(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sum += 0;
            } else if (i % 3 == 0) {
                sum += 0;
            } else {
                sum += 1;
            }
        }
        return sum;
    }

    public int bulbSwitchII(int n) {
        long low = 0;
        long high = n;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if ((mid * mid) == n)
                return (int) mid;
            else if ((mid * mid) < n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return (int) low - 1;
    }

}
