package LeetcodeCodeProblems;

public class MaxLengthPathDfs {
    private static int path = 0;
    private static final int[] dir = {1, 0 , -1, 0};

    public static void main(String[] args) {
        String[] strArr = {"1234", "2345", "4567", "3456"};
//        int x = 3244;
        StringBuilder sb = new StringBuilder();
        String st = "112341";
        int x = Integer.parseInt(st);
//        String xs =
        String str = "Hello world";
        String abc = new String("Hello world");

        if (str.equals(abc)) System.out.println("Both are same");
        else System.out.println("they are different");


        System.out.println(x);
        int[][] nums = {{1, 2, 3, 4}, {2, 3, 4, 5,}, {4, 5, 6, 7}, {3, 4, 5, 6}};
        int[][] visited = new int[4][4];
        int maxConnections = 0;
        int maxPath = 0;
        int maxLen = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                path = 0;
//                System.out.println("for DFS Call: i" + i + " ,j : " + j);
                int tempLen = dfs(nums, i, j, visited, 0);
//                System.out.println(tempLen);
                if (tempLen > maxLen) {
                    maxLen = tempLen;
                    maxConnections = path;
                }
            }
        }
        System.out.println("maxLength: " + maxLen);
        System.out.println("path: " + maxConnections);
    }

    public static boolean isValid(int i, int j, int[][] nums) {
        if (i >=0 && j >=0 && i <nums.length && j < nums[0].length) return true;
        return false;
    }

    public static int dfs(int[][] nums, int i, int j, int[][] visited, int steps) {

        visited[i][j] = 1;
        int sum = nums[i][j];
        int maxSum = 0;
        for (int k = 0; k < 4; k++) {
            int newX = i + dir[k];
            int newY = j + dir[(k + 1) % 4];
            if (isValid(newX, newY, nums) && visited[newX][newY] == 0 && nums[newX][newY] > nums[i][j]) {
                maxSum = Math.max(dfs(nums, newX, newY, visited, steps + 1), maxSum);
            }
        }
        visited[i][j] = 0;
        path = Math.max(path, steps);
        return sum + maxSum;
    }
}
