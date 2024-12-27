//package LeetcodeCodeProblems;
//
//
//import java.util.ArrayList;
//
//public class ClosestPallindrome {
//    public String ClosestPallindromeFind(String strEle) {
//        if (isPallindrome(strEle)) {
//            return strEle;
//        }
//        for (int i = 0; i < strEle.length(); i++) {
//
//        }
//        return strEle;
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
//    public Boolean isPallindrome(String strEle) {
//        int i = 0, n = strEle.length() - 1;
//        while (i < n) {
//            if (strEle.charAt(i) != strEle.charAt(n)) return false;
//        }
//        return true;
//    }
//}
