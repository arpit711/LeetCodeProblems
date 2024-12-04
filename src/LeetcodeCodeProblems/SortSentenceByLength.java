package LeetcodeCodeProblems;

import java.util.Arrays;
import java.util.Comparator;

public class SortSentenceByLength {
    public static void main(String[] args) {
        String sentence = "Houston we have at problem.";

        // Remove the period and split the sentence into words
        sentence = sentence.replace(".", "");
        String[] words = sentence.split(" ");

        // Store the first word of the original sentence
        String firstWord = words[0];

        // Sort the words by length, maintaining relative order in case of ties
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // Convert the original first word to lowercase in the sorted array
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(firstWord)) {
                words[i] = words[i].toLowerCase();
                break;
            }
        }

        // Join the sorted words back into a sentence
        String sortedSentence = String.join(" ", words);

        // Capitalize the first character of the new sentence and add a period at the end
        if (sortedSentence.length() > 0) {
            sortedSentence = sortedSentence.substring(0, 1).toUpperCase() + sortedSentence.substring(1) + ".";
        }

        // Print the sorted sentence
        System.out.println(sortedSentence);
    }
}
