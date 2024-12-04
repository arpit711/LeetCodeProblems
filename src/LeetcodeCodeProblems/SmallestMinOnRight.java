package LeetcodeCodeProblems;

import java.util.Stack;

public class SmallestMinOnRight {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(prices[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] < stk.peek()) {
                while (!stk.isEmpty() && prices[i] < stk.peek()) {
                    stk.pop();
                }
            }
            stk.push(prices[i]);
        }
        for (int i = 0; i < n; i++) {
            int discountPrice = 0;
            while (prices[i] <= stk.peek() && !stk.isEmpty()) {
                stk.pop();
            }
            if (!stk.isEmpty()) discountPrice = stk.peek();
            res[i] = prices[i] - discountPrice;
        }
        return res;
    }
}
