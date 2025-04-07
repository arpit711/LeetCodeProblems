package LeetcodeCodeProblems.DPSeriesStriver;
public class NinjaTrainingProblemDPAllApproaches {
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][3];
        // return find(n - 1, 3, points, dp);
        // Code without the recursion in tabular fashion.
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        dp[0][2] = points[0][2];

        // int maxValue = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.max(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + points[i][j];
                // maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    public static int find(int n, int lastAction, int[][] points, int[][] dp) {

        if (n < 0) return 0;
        if (n == 0) {
            int maxPoints = 0;
            for (int i = 0; i < 3; i++) {
                if (i != lastAction) {
                    maxPoints = Math.max(maxPoints, points[0][i]);
                }
            }
            dp[0][lastAction] = maxPoints;
            return maxPoints;
        }

        if (dp[n][lastAction] != 0) return dp[n][lastAction];
        int maxPoints = 0;
        for (int i = 0; i < 3; i++) {
            if (i != lastAction) {
                int recurseFind = find(n - 1, i, points, dp);
                maxPoints = Math.max(maxPoints, points[n][i] + recurseFind);
            }
        }
        dp[n][lastAction] = maxPoints;
        return maxPoints;
    }

}