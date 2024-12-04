import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
