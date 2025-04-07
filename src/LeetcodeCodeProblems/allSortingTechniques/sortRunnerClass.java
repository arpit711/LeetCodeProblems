package LeetcodeCodeProblems.allSortingTechniques;

import java.util.Arrays;
import java.util.Queue;

public class sortRunnerClass {
    static HeapSort heapSort = new HeapSort();
    static MergeSort mergeSort = new MergeSort();
    static QuickSort quickSort = new QuickSort();
    public static void main(String[] args) {
        System.out.println(Arrays.toString(heapSort.sortArray(new int[] {3, 2, 1, -1, 9})));
        System.out.println(Arrays.toString(mergeSort.sortArray(new int[] {3, 2, 1, -1, 9})));
        System.out.println(Arrays.toString(quickSort.sortArray(new int[] {3, 2, 1, -1, 9})));
//        System.out.println();
    }

}
