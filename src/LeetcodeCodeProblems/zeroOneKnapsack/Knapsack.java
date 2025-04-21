package LeetcodeCodeProblems.zeroOneKnapsack;
/*
* wt ->  3 ,2, 5
* Val-> 30, 40, 60
* target number = 6.
* Greedy not possible hence DP used for try all combinations */

import java.util.Arrays;

public class Knapsack {
//    tabulation approach.
public static void main(String[] args) {
    int[] weight = {3 ,2, 5};
    int[] values = {30, 40, 60};
    int target = 6;
//    System.out.println(knapsack(weight, values, 2, target));
//    test code for practice of string split.
//    String str = "The day began as still as the";
//    for (String strVal : str.split(" ")) {
//        System.out.println(strVal);
//    }
}

static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    int[][] dp = new int[weight.length][maxWeight + 1];
    for (int[] row : dp)
        Arrays.fill(row, -1);
    for (int weightVal = weight[0]; weightVal < maxWeight; weightVal++) {
        dp[0][weightVal] = value[0];
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= maxWeight; j++) {
            int notTake = dp[i - 1][j];
            int take = Integer.MIN_VALUE;
            if (weight[i] <= j) {
                take = value[i] + dp[i - 1][j - weight[i]];
            }
            dp[i][j] = Math.max(take, notTake);
        }
    }
    for (int[] row : dp) {
        for (int item : row) System.out.print(item + " ,");
        System.out.println();
    }
    return dp[n][maxWeight];
}

//    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//        int[][] dp = new int[weight.length][maxWeight + 1];
//        for (int[] row : dp)
//            Arrays.fill(row, -1);
//        return findMaxAcheivable(weight, value, n - 1, maxWeight, dp);
//    }

    public static int findMaxAcheivable(int[] wt, int[] val, int n, int maxWeight, int[][] dp) {
        if (n == 0) {
            // System.out.println(wt[0] +" " + maxWeight);
            if (wt[0] <= maxWeight) return val[0];
            else return 0;
        }
//        System.out.println("test print stmnt");
        if (dp[n][maxWeight] != -1) return dp[n][maxWeight];
        int notTake = findMaxAcheivable(wt, val, n - 1, maxWeight, dp);
        int take = Integer.MIN_VALUE;
        if (wt[n] <= maxWeight) {
            take = val[n] + findMaxAcheivable(wt, val, n - 1, maxWeight - wt[n], dp);
        }
        dp[n][maxWeight] = Math.max(take, notTake);
        return dp[n][maxWeight];
    }
}
