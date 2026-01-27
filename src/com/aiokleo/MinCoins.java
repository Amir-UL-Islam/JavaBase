package com.aiokleo;

import java.util.*;

// DP: Bottom-Up approach
public class MinCoins {
    // Time Complexity: O(n * x)
    // Space Complexity: O(x)
    public static int minCoins(int n, int x, int[] coins) {
        // Initialize the dp array with a large value
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: 0 coins needed to make sum 0

        // Fill the dp array
        for (int s = 1; s <= x; s++) {
            for (int coin : coins) {
                if (s - coin >= 0 && dp[s - coin] != Integer.MAX_VALUE) {
                    dp[s] = Math.min(dp[s], dp[s - coin] + 1);
                }
            }
        }

        // If dp[x] is still MAX_VALUE, it's not possible to form the sum
        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        // Output the result
        System.out.println(minCoins(n, x, coins));
    }
}
