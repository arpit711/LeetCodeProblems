package LeetcodeCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
//        String[] digitMap = new String[10];
        String[] digitMap = {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        String tempStr = "";
        findSequence(digits, result, tempStr);
        return result;
    }

    public void findSequence(String digits, List<String> result, String tempStr, String[] digitMap) {
        if (digits.length() == 0) {
            result.add(tempStr);
            return;
        }
        for (int i = 0; i < digits.length(); i++) {
            int tempNum = digits.charAt(i) - '0';
            for (int j = 0; j < digitMap[tempNum].length(); j++) {
                tempStr += digitMap[tempNum].charAt(j);
                findSequence(digits.substring(i + 1), result, tempStr);
                tempStr = tempStr.substring(0, tempStr.length() - 1);
            }
        }

    }
}
