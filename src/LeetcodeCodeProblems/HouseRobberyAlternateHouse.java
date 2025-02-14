package LeetcodeCodeProblems;

public class HouseRobberyAlternateHouse {
    //  T = 2^n -> n
//    space => o(n) + O(n)

    public static int maximizeProfit(int[] houses, int index, int[] dp) {
        if (index >= houses.length) return 0;
        if (dp[index] != -1) return dp[index];
        //        select house
        int selected = houses[index] +  maximizeProfit(houses, index + 2, dp);
        int notSelected = maximizeProfit(houses, index + 1, dp);
        dp[index] = Math.max(selected, notSelected);
        return dp[index];
    }

    public static int maximizeProfitArray(int[] houses) {
        for (int i = houses.length - 3; i >=0; i--) {
            if (houses[i] + houses[i + 2] > houses[i + 1]) {
                houses[i] = houses[i] + houses[i + 2];
            } else {
                houses[i] = houses[i + 1];
            }
        }
        return houses[0];
    }

}
