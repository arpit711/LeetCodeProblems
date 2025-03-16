package LeetcodeCodeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node, parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class CycleInDirectedGraph {
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Pair> bfsQueue = new LinkedList<>();
        boolean[] isVisited = new boolean[adj.size()];
        if (adj.size() == 1) return false;
        bfsQueue.add(new Pair(0, -1));
        while (!bfsQueue.isEmpty()) {
            Pair pair = bfsQueue.poll();
            int node = pair.node;
            int parent = pair.parent;
            isVisited[node] = true;
            for (int element : adj.get(node)) {
                if (!isVisited[element]) {
                    bfsQueue.add(new Pair(element, node));
                } else if (element != parent) {
                    if (isVisited[element]) return true;
                }
            }
        }
        return false;
    }
}
//(0 , -1)
//        (1, 0)
//1, (0,2,3,4)
