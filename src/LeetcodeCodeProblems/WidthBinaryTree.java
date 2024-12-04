//package LeetcodeCodeProblems;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//class TreeNode{
//    TreeNode  left, right;
//    int val;
//
//    public TreeNode(TreeNode left, TreeNode right, int val) {
//        this.left = left;
//        this.right = right;
//        this.val = val;
//    }
//}
//
//class Pair{
//    TreeNode root;
//    int index;
//
//    public Pair(TreeNode root, int i) {
//        this.root = root;
//        this.index = i;
//    }
//}
//
//
//public class WidthBinaryTree {
//    public int widthOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
//        Queue<Pair1> q = new LinkedList<Pair1>();
//        q.add(new Pair1(root, 0));
//        int ans = 0;
//        while (!q.isEmpty()) {
//            int maxIndex = 0, minIndex = 0;
//            int mmin = q.peek().index;
//            int size = q.size();
//            for (int i  = 0; i < size; i++) {
//                int currId = q.peek().index - mmin;
//                int actIndex = q.peek().index;
//                TreeNode tempNode = q.peek().root;
//                q.poll();
//                if (i == 0) minIndex = actIndex;
//                if (i == size - 1) maxIndex = actIndex;
//                if (tempNode.left != null) {
//                    q.add(new Pair1(tempNode.left, currId*2 + 1));
//                }
//                if (tempNode.right != null) {
//                    q.add(new Pair1(tempNode.right, currId*2 + 2));
//                }
//            }
//            ans = Math.max(ans, maxIndex - minIndex + 1);
//        }
//        return ans;
//    }
//}
