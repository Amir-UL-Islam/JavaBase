package com.aiokleo.problemSolving.coinChange;

import java.util.Arrays;

class CoinsSolution {
    public int coinChange(int[] coins, int amount) {
        //[1, 2, 5] -> 5 + 5 + 1 = 11 => 3 Minimum Number of Coins
        Arrays.sort(coins);
        int number = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount >= coins[i] && amount % coins[i] == 0) {
                number += amount / coins[i];
                break;
            } else if (i != 0 && amount >= coins[i]) {
                number += amount / coins[i];
                amount = amount % coins[i];
            } else if (i == 0 && amount != 0){
                number = -1;
            }
        }
        return number;
    }
}
