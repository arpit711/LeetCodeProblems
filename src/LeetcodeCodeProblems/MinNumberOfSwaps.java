package LeetcodeCodeProblems;

import java.util.Arrays;
import java.util.HashMap;

public class MinNumberOfSwaps {
    public int minSwaps(int nums[]) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int cycle = 0;
            if (visited[i] == true || nums[i] == i) continue;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]);
                cycle++;
            }
            ans += (cycle - 1);
        }
        return ans;

    }
}
