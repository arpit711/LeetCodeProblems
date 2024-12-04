package LeetcodeCodeProblems;

import java.util.Arrays;

class Solution1 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = calculateCoins(coins.length - 1, amount, coins, dp);
        return ans;
    }

    public int calculateCoins(int index, int amount, int[] coins, int[][] dp) {
        if (index == 0 && amount % coins[index] == 0) return 1;
        if (dp[index][amount] != -1) return dp[index][amount];
        int nonTake = calculateCoins(index - 1, amount, coins, dp);
        int take = 0;
        if (coins[index] <= amount)
            take = calculateCoins(index, amount - coins[index], coins, dp);
        dp[index][amount] = take + nonTake;
        return dp[index][amount];
    }
}