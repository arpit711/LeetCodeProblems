import java.util.*;

public class TestClass {

    public static int maximumSumDifference(List<Integer> item_weights) {
        int n = item_weights.size();
        int size = n / 3;

        // Prefix sum for largest n/3 elements up to each index
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long[] prefixSum = new long[n];
        long prefixTotal = 0;

        for (int i = 0; i < n; i++) {
            minHeap.add(item_weights.get(i));
            prefixTotal += item_weights.get(i);

            if (minHeap.size() > size) {
                prefixTotal -= minHeap.poll();
            }

            prefixSum[i] = (i < size - 1) ? Long.MIN_VALUE : prefixTotal;
        }

        // Suffix sum for smallest n/3 elements from each index
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long[] suffixSum = new long[n];
        long suffixTotal = 0;

        for (int i = n - 1; i >= 0; i--) {
            maxHeap.add(item_weights.get(i));
            suffixTotal += item_weights.get(i);

            if (maxHeap.size() > size) {
                suffixTotal -= maxHeap.poll();
            }

            suffixSum[i] = (i > n - size) ? Long.MAX_VALUE : suffixTotal;
        }

        // Calculate maximum difference
        long maxDifference = Long.MIN_VALUE;
        for (int i = size - 1; i < n - size; i++) {
            maxDifference = Math.max(maxDifference, prefixSum[i] - suffixSum[i + 1]);
        }

        return (int) maxDifference;
    }

    public static void main(String[] args) {
        // Example Test Case
        List<Integer> item_weights = Arrays.asList(-3,-2,-1);
        System.out.println(maximumSumDifference(item_weights)); // Output should be 4
    }
}