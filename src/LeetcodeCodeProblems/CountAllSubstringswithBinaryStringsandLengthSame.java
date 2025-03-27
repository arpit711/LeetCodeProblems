package LeetcodeCodeProblems;

public class CountAllSubstringswithBinaryStringsandLengthSame {
    public static int count(String str) {
        int count = 0;
        for (int i =0; i < str.length(); i++) {
            int value = 0;
            for (int j = i; j < str.length(); j++) {
                value = (value << 1) | (str.charAt(j) - '0');
                if (value == (j - i - 1)) {
                    count++;
                }
                if (value > str.length()) break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(count("11010001001"));
        int x = 0;
        String str = "1011010101";
        for (int i = 0; i < str.length(); i++) {
            x = (x << 1) | (str.charAt(i) - '0');
            System.out.println(x);
        }
//        System.out.println(x << 1 | str.char);
    }
}
