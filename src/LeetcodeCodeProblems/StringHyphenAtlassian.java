package LeetcodeCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class StringHyphenAtlassian {
    public static List<String> wrapLines(String[] words, int target) {
        StringBuilder currentLine = new StringBuilder();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (currentLine.isEmpty()) {
                currentLine.append(word);
            } else if (currentLine.length() + 1 + word.length() <= target) {
                currentLine.append("-").append(word);
            } else {
                result.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            }
        }
        if (!currentLine.isEmpty()) {
            result.add(currentLine.toString());
        }
//        for(String word : result) {
//            System.out.println(word);
//        }
        return result;
    }

    public static void main(String[] args) {
        String[] words1 = {"The", "day", "began", "as", "still", "as", "the", "night", "abruptly", "lighted", "with", "brilliant", "flame"};
        String[] words2 = {"Hello"};
        String[] words3 = {"Hello", "Hello"};
        String[] words4 = {"Well", "Hello", "world"};
        String[] words5 = {"Hello", "HelloWorld", "Hello", "Hello"};
        String[] words6 = {"a", "b", "c", "d"};

        System.out.println(wrapLines(words1, 13));
        System.out.println(wrapLines(words1, 12));
        System.out.println(wrapLines(words1, 20));
        System.out.println(wrapLines(words2, 5));
        System.out.println(wrapLines(words2, 30));
        System.out.println(wrapLines(words3, 5));
        System.out.println(wrapLines(words4, 5));
        System.out.println(wrapLines(words5, 20));
        System.out.println(wrapLines(words6, 20));
        System.out.println(wrapLines(words6, 4));
        System.out.println(wrapLines(words6, 1));
    }
}
