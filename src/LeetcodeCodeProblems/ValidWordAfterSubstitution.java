package LeetcodeCodeProblems;

import java.util.*;

public class ValidWordAfterSubstitution {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        String strEle = "abababccc";
//        for (Character item : strEle.toCharArray()) {
//            System.out.println(item);
//        }
        Integer[] abs = {1,2,3,-1, 0};
        Arrays.sort(abs,(a,b) -> b-a);
//        Arrays.sort(abs, Comparator.reverseOrder());
//        System.out.println(Arrays.toString(abs));
        int product = 1232445;
        int tempProduct = 1214131;
        String nStr = String.valueOf(product);
        String npStr = String.valueOf(tempProduct);
        for (char c: npStr.toCharArray()) {
            System.out.println("value: " + nStr.indexOf(c));
        }
    }
}