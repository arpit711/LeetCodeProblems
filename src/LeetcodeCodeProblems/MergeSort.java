package LeetcodeCodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//instead of passing by reference for the variables the best idea is to use the class for the same.
/*and the class will encapsulate the object inside of it otherwise the static element will return
 the same output everytime and will be wrong answer always*/
public class MergeSort {
    public static class Counter {
        int countInversions = 0; // Encapsulates the count of inversions
    }
//    static int countInversions = 0;
    public static List<Integer> mergeSort(List<Integer> arr, int start, int end, Counter counter) {

        if (start == end) {
            return (new ArrayList<Integer>(Arrays.asList(arr.get(start))));
        }
        int mid = (start + end) / 2;
        List<Integer> array1 = mergeSort(arr, start, mid, counter);
        List<Integer> array2 = mergeSort(arr, mid + 1, end, counter);
        return mergeArray(array1, array2,counter);

    }

    private static List<Integer> mergeArray(List<Integer> array1, List<Integer> array2, Counter counter) {
        int start1 = 0, start2 = 0, end1 = array1.size() - 1, end2 = array2.size() - 1;
        List<Integer> tempList = new ArrayList<>();

//        count inversions as well in the same step.
        while (true) {
            while (start1 < array1.size() && start2 < array2.size() &&
                    array1.get(start1) < array2.get(start2)) {
                tempList.add(array1.get(start1));
                start1++;
            }
            if (start1 != array1.size() && array1.get(start1) > array2.get(start2)) {
                counter.countInversions += (array1.size() - start1);
            }
            tempList.add(array2.get(start2));
            start2++;
            if (start2 == array2.size() || start1 == array1.size()) break;
        }
        if (start1 != array1.size()) {
            while (start1 != array1.size()) {
                tempList.add(array1.get(start1++));
            }
        }
        if (start2 != array2.size()) {
            while (start2 != array2.size()) {
                tempList.add(array2.get(start2++));
            }
        }
        return tempList;
    }

    public static void main(String[] args) {
//        int[] arr1 = {3,1,5,4,2,0,9,8};
        List<Integer> arr = Arrays.asList(6,5,4,3,2,1);
        System.out.println(arr.toString());
        Counter counter = new Counter();
       List<Integer> arrNew= mergeSort(arr, 0, arr.size() - 1, counter);
        System.out.println(arrNew.toString());
        System.out.println("Inversions count: " + counter.countInversions);
    }
}
