//package LeetcodeCodeProblems;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////2->4
////3->7
////1->4
////To create a list of lists of integers in Java,
//// you can use the List interface along with the ArrayList class.
//// Java's List is an interface, and ArrayList is a class that implements it,
//// allowing for dynamic arrays.
//public class topKFrequents {
//    public int[] topKFrequent(int[] nums, int k) {
//        if (k == nums.length) return nums;
//        Map<Integer, Integer> count = new HashMap<>();
//        for (int num: nums) {
//            count.put(num, count.getOrDefault(nums, 0) + 1);
//        }
//
//        List<Integer>[] buckets = new List[nums.length + 1];
//        List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
//        for (int i = 0; i < buckets.size(); i++) {
//            buckets[i] = new ArrayList();
//        }
//
//    }
//}
