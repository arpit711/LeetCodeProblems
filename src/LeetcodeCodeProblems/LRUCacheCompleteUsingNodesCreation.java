/*designing LRU cache
* insert element, get element
*
* */

package LeetcodeCodeProblems;

import jdk.jshell.execution.Util;

import java.nio.channels.CompletionHandler;
import java.util.*;

public class LRUCacheCompleteUsingNodesCreation {

    CacheNode head, tail;
    Map<Integer, CacheNode> cacheMap;
    int capacity;
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

    class UtilityMethods {
        private static CacheNode head;
        private static CacheNode tail;
        public static void initialize(CacheNode head, CacheNode tail) {
            UtilityMethods.head = head;
            UtilityMethods.tail = tail;
        }

        public static void addToLast(CacheNode node) {
            tail.left.right = node;
            node.right = tail;
            node.left = tail.left;
            tail.left = node;
        }

        public static CacheNode removeNode(CacheNode tempNode) {
            tempNode.right.left = tempNode.left;
            tempNode.left.right = tempNode.right;
            tempNode.left = null;
            tempNode.right = null;
            return tempNode;
        }

//    public void addToFirst(CacheNode node) {
//        node.right = head.right;
//        node.left = head;
//        head.right.left = node;
//        head.right = node;
//    }
    }
    public LRUCacheCompleteUsingNodesCreation(int capacity) {
        this.capacity = capacity;
        head = new CacheNode(-1, -1);
        tail = new CacheNode(-1, -1);
        cacheMap = new HashMap<>();
        head.right = tail;
        tail.left = head;
        UtilityMethods.initialize(head, tail);
    }


    public int get(int key) {
//        store key to map as well parallel.
        if (cacheMap.containsKey(key)) {
            UtilityMethods.removeNode(cacheMap.get(key));
            UtilityMethods.addToLast(cacheMap.get(key));
            return cacheMap.get(key).value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        CacheNode tempNode;
        if (!cacheMap.containsKey(key)) {
            tempNode = new CacheNode(key, value);
            if (cacheMap.size() >= capacity) {
                CacheNode removedNode = UtilityMethods.removeNode(head.right);
                cacheMap.remove(removedNode.key);
            }
            cacheMap.put(key, tempNode);
            UtilityMethods.addToLast(tempNode);
        }
        tempNode = cacheMap.get(key);
        tempNode.key = key;
        tempNode.value = value;
        UtilityMethods.removeNode(tempNode);
        UtilityMethods.addToLast(tempNode);
        System.out.println("successfully added element to the list");
        CacheNode tempNode2 = head;
    }

    public static void main(String[] args) {
        List<Integer> cache = Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3);
        LRUCacheCompleteUsingNodesCreation cacheStructure = new LRUCacheCompleteUsingNodesCreation(3);
        for (int ele: cache) {
            cacheStructure.put(ele, ele);
        }
        for (CacheNode nodeElements: cacheStructure.cacheMap.values()) {
            System.out.println(nodeElements.key + " " + nodeElements.value);
        }

    }
}

