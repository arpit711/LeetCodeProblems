package LeetcodeCodeProblems;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ComparatorsJavaLambdaAndComparing {
    public static void main(String[] args) {
        int[][] arr = {{3,1},{5,3},{4,2},{5,6},{2,3},{4,6}};
        arr = Arrays.stream(arr).sorted((a, b)->Integer.compare(b[0], a[0]))
               .toArray(int[][]::new);
//        for (int[] item : arr) {
//            System.out.print(item[0] + " " + item[1]);
//            System.out.println();
//        }

        arr = Arrays.stream(arr).sorted((a, b)->Integer.compare(b[1], a[1]))
                .toArray(int[][]::new);
        System.out.println("******************");
//        for (int[] item : arr) {
//            System.out.print(item[0] + " " + item[1]);
//            System.out.println();
//        }

//        stream with second level of sorting used here.
        List<int[]> sortedList = Arrays.stream(arr)
                .sorted((a, b) -> {
                    int firstCompare = Integer.compare(a[0], b[0]); // First element sorting
                    return (firstCompare != 0) ? firstCompare : Integer.compare(a[1], b[1]); // If tie, use second element
                }).toList();

//        just opposite of Above
        List<int[]> sortedListDescending = Arrays.stream(arr)
                .sorted((a, b) -> {
                    int firstCompare = Integer.compare(b[0], a[0]); // First element sorting
                    return (firstCompare != 0) ? firstCompare : Integer.compare(b[1], a[1]); // If tie, use second element
                })
                .toList();

        for (int[] arrItem: sortedListDescending) {
            System.out.println(Arrays.toString(arrItem));
        }
        System.out.println("******Running the priority queue elements traversal*****");

        //        apppl the same analorgy to the priority queue as well whenever we need to
//        set elements in a queue in a second order of sorting technique
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int firstCompare = Integer.compare(b[0], a[0]);
            return (firstCompare != 0) ? firstCompare : Integer.compare(a[1], b[1]);
        });

        for (int[] arrItem: sortedListDescending) {
            pq.offer(arrItem);
            pq.offer(new int[]{999,999});
        }

        while (!pq.isEmpty()) {
            System.out.println(Arrays.toString(pq.poll()));
        }

    }
}
