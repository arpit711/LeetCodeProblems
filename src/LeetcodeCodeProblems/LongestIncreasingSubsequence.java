package LeetcodeCodeProblems;

/*
* The element when not found will be returning -insertion index - 1 as the return value meaning that.
* Collections.BinarySearch Has not found the element instead it should be placed at the index eg..-4
* from -4 we need to convert back to make it positive integer by doing pos = -pos - 1  -(-4) - 1 = 3
* hence new element can be added to index 3
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    /*
     * The element when not found will be returning -insertion index - 1 as the return value meaning that.
     * Collections.BinarySearch Has not found the element instead it should be placed at the index e.g -4
     * from -4 we need to convert back to make it positive integer by doing pos = -pos - 1  -(-4) - 1 = 3
     * hence new element can be added to index 3
     */

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) {
                pos = -pos - 1; // Convert to insertion index
            }
            if (pos < lis.size()) {
                lis.set(pos, num); // Replace existing value
            } else {
                lis.add(num); // Extend LIS
            }
        }
        return lis.size();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{1,7,8,4,5,6,-1,9}));
    }
}