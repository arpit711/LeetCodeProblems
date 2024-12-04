//package LeetcodeCodeProblems;
//
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
//
//public class SwapPairsListNode {
//    public ListNode swapPairs(ListNode head) {
//       boolean[] dp = new boolean[Integer.MAX_VALUE];
//       int ans = 0;
//       dp[0] = false;
//       for (int i = 0; i < dp.length;i++) {
//           dp[i] = false;
//       }
//       int primeOne = 0, primeTwo = 0;
//       int minNumber = Math.min(primeOne, primeTwo) + 1;
//       int maxNumber = Math.max(primeOne, primeTwo);
//       dp[maxNumber] = true;
//       dp[minNumber] = true;
//       for (int i = minNumber; i <= maxNumber; i++) {
//           if (i - minNumber >= 0) {
//               dp[i] = dp[i - minNumber];
//           }
//           if (i - maxNumber >= 0) {
//               dp[i] = dp[i - maxNumber];
//           }
//       }
//       for (int i = maxNumber + 1; i <= Integer.MAX_VALUE; i++) {
//           dp[i] = (dp[i - maxNumber] || dp[minNumber]);
//           if (dp[i] == false) ans = i;
//       }
//       return ans;
//
//    }
//}
