package LeetcodeCodeProblems;//package LeetcodeCodeProblems;//package LeetcodeCodeProblems;
//
//import java.util.*;
//
//class MyTreeNode {
//    int val;
//    MyTreeNode left, right;
//    MyTreeNode(int val) {
//        this.val = val;
//        this.left = null;
//        this.right = null;
//    }
//}
//public class InterviewProblemTree {
//    List<List<String>> names = new ArrayList<>();
//    List<String> newArray = new ArrayList<>();
//    newArray.add
//    temp.add("ali owes mohan");

//    names.add(Arrays.asList("ali owes mohan"));
//            = [,"ahmad owes mohan","arpit owes manikaran"]
//    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
//    for ()
//}

import java.util.ArrayList;
import java.util.List;

public class InterviewProblemTree {
    public static void Display(String[] args) {
        // Create the outer list
        List<List<String>> names = new ArrayList<>();

        // Initialize an inner list (similar to initializing a string array)
        List<String> nameList = new ArrayList<>();
        nameList.add("John");
        nameList.add("Alice");
        nameList.add("Bob");

        // Add the inner list to the outer list
        names.add(nameList);

        // Initialize another inner list and add it to the outer list
        List<String> anotherNameList = new ArrayList<>();
        anotherNameList.add("Emma");
        anotherNameList.add("Chris");

        names.add(anotherNameList);

        // Print the outer list
        System.out.println(names);
    }
}