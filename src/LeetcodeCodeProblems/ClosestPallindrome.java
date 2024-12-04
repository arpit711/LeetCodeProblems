//package LeetcodeCodeProblems;
//
//
//import java.util.ArrayList;
//
//public class ClosestPallindrome {
//    public String ClosestPallindromeFind(String str) {
//        if (isPallindrome(str)) {
//            return str;
//        }
//        for (int i = 0; i < str.length(); i++) {
//
//        }
//        return str;
//    }
//    public String nearestPallindromic(String n) {
//        ArrayList<Long> list = new ArrayList<Long>();
//        int len = n.length();
//        int mid = (len%2 == 0)? len / 2: len/2 + 1;
//        Long firstHalf = Long.parseLong(n.substring(0, mid));
//        list.add((firstHalf));
//
//
//    }
//
//    public Boolean isPallindrome(String str) {
//        int i = 0, n = str.length() - 1;
//        while (i < n) {
//            if (str.charAt(i) != str.charAt(n)) return false;
//        }
//        return true;
//    }
//}
