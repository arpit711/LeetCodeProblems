package LeetcodeCodeProblems;

import java.util.ArrayList;
import java.util.TreeMap;

public class MaxStack {
    private class Node{
        int val;
        Node prev;
        Node next;
        public Node(int x) {
            val = x;
            prev = null;
            next = null;
        }
    }
    private TreeMap<Integer, ArrayList<Node>> tMap;
    final private Node head;
    final private Node tail;

    public MaxStack() {
        tMap = new TreeMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public void push(int x) {
//        push inside a ll at top position
//        add entry to the map
        Node node = addTop(x);
        ArrayList<Node> al = new ArrayList<>();
        if (tMap.containsKey(x)) {
            al = tMap.get(x);
        } else {
            tMap.put(x, al);
        }
        tMap.get(node.val).add(node);
    }

    private Node addTop(int x) {
        Node temp = new Node(x);
        temp.prev = tail.prev;
        temp.next = tail;
        tail.prev.next = temp;
        tail.prev = temp;
        return temp;
    }

    public int pop() {
        Node high = getTop();
        ArrayList<Node> al = tMap.get(high.val);
        al.removeLast();
        if (al.isEmpty()) {
            tMap.remove(high.val);
        }
        remove(high);
        return high.val;
    }

    private Node getTop() {
        return tail.prev;
    }

    public int top() {
        Node temp = getTop();
        return temp.val;
    }

    public int peekMax() {
        Integer x = tMap.lastKey();
        return x;
    }

    public int popMax() {
        Integer x = tMap.lastKey();
        ArrayList<Node> al = tMap.get(x);
        Node lastNode = al.removeLast();
        if (al.isEmpty()) tMap.remove(x);
        remove(lastNode);
        return x;
    }
    public void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

}
