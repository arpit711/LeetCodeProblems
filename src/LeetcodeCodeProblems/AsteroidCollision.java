package LeetcodeCodeProblems;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair1 {
    Node root;
    int index;

    public Pair1(Node root, int i) {
        this.root = root;
        this.index = i;
    }
}

public class AsteroidCollision {
    static ArrayList<Integer> topView(Node root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> solution = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair1> queue = new LinkedList<>();
        queue.add(new Pair1(root, 0));
        while (!queue.isEmpty()) {
            Pair1 p = queue.poll();
            int index = p.index;
            Node node = p.root;
            if (map.get(index) == null) map.put(index, node.data);
            if (node.left != null) {
                queue.add(new Pair1(node.left, index - 1));
            }
            if (node.right != null) {
                queue.add(new Pair1(node.right, index + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            solution.add(entry.getValue());
        }
        return solution;
    }
}
