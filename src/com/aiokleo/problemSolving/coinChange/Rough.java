package com.aiokleo.problemSolving.coinChange;

class Rough {
    public static void main(String[] args) {
        CoinsSolution solution = new CoinsSolution();
        int[] coins = new int[] { 1, 2, 5 };
        System.out.println("Answer is: " + String.valueOf(solution.coinChange(coins, 11)));
    }
}
