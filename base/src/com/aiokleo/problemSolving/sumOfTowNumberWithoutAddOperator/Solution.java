package com.aiokleo.problemSolving.sumOfTowNumberWithoutAddOperator;

class Solution {
    static int add(int a, int b) {
        int keep = (a & b) << 1;
        int res = a ^ b;

        // If bitwise & is 0, then there
        // is not going to be any carry.
        // Hence result of XOR is addition.
        if (keep == 0)
            return res;

        return add(keep, res);
    }

    //    The bitwise AND & operator returns 1 if and only if both the operands are 1. Otherwise, it returns 0.
//    a = 5 = 0101 (In Binary)
//  & b = 7 = 0111 (In Binary)
// -------------------
//  a&b =     0101
//    After shifting 1 bit left, we get 1010. We have a carry bit now.
//    But not the final answer.
    public int getSum(int a, int b) {
        int keep = (a & b) << 1;
        int res = a ^ b;
        while (keep != 0) {
            int temp = keep;
            keep = (keep & res) << 1;
            res = temp ^ res;

        }
//        return add(a, b);
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(1, 2));
    }
}