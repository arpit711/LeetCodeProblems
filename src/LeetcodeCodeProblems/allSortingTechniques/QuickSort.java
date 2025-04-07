package LeetcodeCodeProblems.allSortingTechniques;

public class QuickSort {
//     *******************************Quick Sort**********************************
 public int[] sortArray(int[] nums) {
     int n = nums.length;
     qsort(nums, 0, n - 1);
     return nums;
 }
 public void qsort(int[] nums, int low, int high) {
     if (low > high) return;
     int pivot = createPivot(nums, low, high);
     qsort(nums, low, pivot - 1);
     qsort(nums, pivot + 1, high);
 }

 public int createPivot(int[] nums, int low, int high) {
     int pivot = nums[low];
     int i = low, j = high;
     while (i < j) {
         while (nums[i] <= pivot && i <= high - 1) i++;
         while (nums[j] > pivot && j >= low + 1) j--;
         if (i < j) swap(nums, i , j);
     }
     swap(nums, low, j);
     return j;
 }

     public void swap(int[] nums, int index1, int index2) {
     int temp = nums[index1];
     nums[index1] = nums[index2];
     nums[index2] = temp;
 }
}