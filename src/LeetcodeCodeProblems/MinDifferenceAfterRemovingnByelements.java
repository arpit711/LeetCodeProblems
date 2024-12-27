package LeetcodeCodeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinDifferenceAfterRemovingnByelements {
    public static long minimumDifference(int[] nums) {
//        nums = {7, 9, 5, 8, 1, 3};
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a, b) -> b - a);
        long maxSum = 0, minSum = 0, minDifference = Long.MAX_VALUE;
        int n = nums.length;
        Long[] suffixSum = new Long[n];
        for (int i = n - 1; i >= 0; i++) {
            pqMin.add(nums[i]);
            maxSum += nums[i];
            if (pqMin.size() == n/3) {
                suffixSum[i++] = maxSum;
            } else if (pqMin.size() > n/3) {
                maxSum -= pqMin.poll();
                suffixSum[i] = maxSum;
            } else suffixSum[i] = 0L;
        }
        for (int i = 0; i < n - 1; i++) {
            pqMax.add(nums[i]);
            minSum += nums[i];
            if (pqMin.size() == n/3) {
                minDifference = Math.min(minDifference, minSum - suffixSum[i+1]);
            } else if (pqMin.size() > n/3) {
                minSum -= pqMax.poll();
                minDifference = Math.min(minDifference, minSum - suffixSum[i+1]);
            } else continue;

        }

        pqMax.add(10);
        pqMax.add(20);
        System.out.println(pqMax.peek());
        return 123123;
    }

    public static void main(String[] args) {
        minimumDifference(new int[]{7, 9, 5, 8, 1, 3});
    }
}
