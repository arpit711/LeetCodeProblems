package LeetcodeCodeProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class HeapPair {
    int i, j, value;

    public HeapPair(int value, int i, int j) {
        this.value = value;
        this.i = i;
        this.j = j;
    }
}

//Maximum Sum Combinations problem with custom comparator saved into it.
public class maxDistanceHeapProblem {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        PriorityQueue<HeapPair> pq = new PriorityQueue<HeapPair>(new ourCustomComparator());
        Collections.sort(A);
        Collections.sort(B);
        int n = A.size();
        HeapPair hp = new HeapPair(A.get(n - 1) + B.get(n - 1), n - 1, n - 1);
        pq.add(hp);
        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            HeapPair temp = pq.peek();
            int value = temp.value;
            int indexI = temp.i;
            int indexJ = temp.j;
            res.add(value);
            pq.poll();
            if (indexI - 1 >= 0)
                pq.add(new HeapPair(A.get(indexI - 1) + B.get(indexJ), indexI - 1, indexJ));
            if (indexJ - 1 >= 0)
                pq.add(new HeapPair(A.get(indexI) + B.get(indexJ - 1), indexI, indexJ - 1));
        }
        return res;


    }

    class ourCustomComparator implements Comparator<HeapPair> {
        public int compare(HeapPair s1, HeapPair s2) {
            if (s1.value < s2.value) return 1;
            else if (s1.value > s2.value) return -1;
            return 0;
        }

    }
}
