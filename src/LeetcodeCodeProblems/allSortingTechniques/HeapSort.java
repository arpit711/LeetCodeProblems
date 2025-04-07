package LeetcodeCodeProblems.allSortingTechniques;

public class HeapSort {
    // Heap sort approach Proper working and submitted approach.
 public int[] sortArray(int[] nums) {
     int n = nums.length;
     // heapify first time.

     for (int i = n/2 - 1; i >= 0; i--) {
         heapify(nums, n, i);
     }
     for (int i = n - 1; i >= 0; i--) {
         swap(nums, i, 0);
         // this heapify will run on the top most node as the tree is rebuilt from the top most node after swapping the last node with top most node values.
         // keep track of reduced array size in order to meet the proper base conditions in heapify logic.
         heapify(nums, i, 0);
     }
     return nums;
 }

 public void heapify(int[] nums, int arrayPresentSize, int i) {
     int largest = i;
     int left = 2 * i + 1;
     int right = 2 * i + 2;

     // if left child is larger than root.
     if (left < arrayPresentSize && nums[left] > nums[largest]) {
         largest = left;
     }

     if (right < arrayPresentSize && nums[right] > nums[largest]) largest = right;

     if (largest != i) {
         swap(nums, largest, i);
         heapify(nums, arrayPresentSize, largest);
     }
 }

 public void swap(int[] nums, int index1, int index2) {
     int temp = nums[index1];
     nums[index1] = nums[index2];
     nums[index2] = temp;
 }



}
