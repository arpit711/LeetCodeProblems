/*designing LRU cache
 * insert element, get element
 *
 * */

package LeetcodeCodeProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CacheNode {
    int key, value;
    CacheNode left, right;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class LRUCacheCompleteUsingNodesCreation {
    int capacity;
    private final CacheNode head;
    private final CacheNode tail;
    private final Map<Integer, CacheNode> cacheMap;

    public LRUCacheCompleteUsingNodesCreation(int capacity) {
        this.capacity = capacity;
        head = new CacheNode(-1, -1);
        tail = new CacheNode(-2, -2);
        cacheMap = new HashMap<>();
        head.right = tail;
        tail.left = head;
    }

    public static void main(String[] args) {
        List<Integer> cache = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3);
        LRUCacheCompleteUsingNodesCreation cacheStructure = new LRUCacheCompleteUsingNodesCreation(5);
        for (int ele : cache) {
            cacheStructure.put(ele, ele);
        }
        for (CacheNode nodeElements : cacheStructure.cacheMap.values()) {
            System.out.println(nodeElements.key + " " + nodeElements.value);
        }

    }

    public void addToLast(CacheNode node) {
        tail.left.right = node;
        node.right = tail;
        node.left = tail.left;
        tail.left = node;
    }

    public void removeNode(CacheNode tempNode) {
        tempNode.right.left = tempNode.left;
        tempNode.left.right = tempNode.right;
        tempNode.left = null;
        tempNode.right = null;
    }

    public int get(int key) {
//        store key to map as well parallel.
        if (cacheMap.containsKey(key)) {
            removeNode(cacheMap.get(key));
            addToLast(cacheMap.get(key));
            return cacheMap.get(key).value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        CacheNode tempNode;
        if (cacheMap.containsKey(key)) {
            tempNode = cacheMap.get(key);
            tempNode.value = value;
            removeNode(tempNode);
            addToLast(tempNode);
        } else {
            if (cacheMap.size() >= capacity) {
                CacheNode nodeToRemove = head.right;
                cacheMap.remove(nodeToRemove.key);
                removeNode(nodeToRemove);
            }
            CacheNode newNode = new CacheNode(key, value);
            addToLast(newNode);
            cacheMap.put(key, newNode);
        }
        System.out.println("successfully added element to the list");
    }
}

