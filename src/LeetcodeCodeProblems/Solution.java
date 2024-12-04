package LeetcodeCodeProblems;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int nearest_sum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 3; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int tempSum = start + end;
                if (tempSum <= target) {
                    nearest_sum = Math.max(nearest_sum, start + end + nums[i]);
                    start++;
                } else end--;
            }
        }
        return 0;
    }
}