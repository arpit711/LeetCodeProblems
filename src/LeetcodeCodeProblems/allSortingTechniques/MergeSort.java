package LeetcodeCodeProblems.allSortingTechniques;

public class MergeSort {
    // *********************************MERGE SORT*****************************************
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int index = 0;
        int[] finalArray = new int[end - start + 1];
        int i, j;
        for (i = start, j = mid + 1; i <= mid && j <= end; ) {
            finalArray[index++] = (nums[i] > nums[j]) ? nums[j++] : nums[i++];
        }
        while (i <= mid && j > end) {
            finalArray[index++] = nums[i++];
        }

        while (j <= end && i > mid) {
            finalArray[index++] = nums[j++];
        }
        for (int k = start; k <= end; k++) {
            nums[k] = finalArray[k - start];
        }
    }
}
