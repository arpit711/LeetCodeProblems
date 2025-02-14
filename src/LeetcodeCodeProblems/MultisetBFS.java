package LeetcodeCodeProblems;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MultisetBFS {

    public int countServers(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[] dir = {-1, 0, 1, 0};
        int level = 1;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        Arrays.fill(visited, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i , j});
                }
            }
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int[] tempArr = queue.poll();
                int iIndex = tempArr[0];
                int jIndex = tempArr[1];
                int newiIndex, newjIndex;
                visited[iIndex][jIndex] = level;
                for (int k = 0; k < 4; k++) {
                    newiIndex = dir[k] + iIndex;
                    newjIndex = dir[(k + 1) % 4] + jIndex;
                    if (isValid(newiIndex, newjIndex, m, n) && !(visited[newiIndex][newjIndex] >0)) {
                        queue.offer(new int[]{newiIndex, newjIndex});
                    }
                }
                queue.poll();
            }
            level++;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] > 0) {
                    count++;
                }
            }
        }
        return 0;
    }

    private boolean isValid(int newiIndex, int newjIndex, int m, int n) {
        return (newiIndex >= 0 && newjIndex >=0 && newjIndex < n && newiIndex < m);
    }
}
