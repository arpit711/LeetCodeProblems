import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.*;
import java.util.Set;
import java.util.TreeSet;
class Pair{
    int i,j;
}
public class CheatBookJavaCollections {
    public static void main(String[] args) {
        Set<String> names = new HashSet<String>();
        names.add("string");
        names.add("string");
        names.add("string");
        names.add("walter");
        names.add("arpit");
        names.add("amit");

//        ways to iterate over the set below
        names.forEach(System.out::println);
        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()) {
            System.out.println(namesIterator.next());
        }
//        System.out.println(names);

        List<Integer> numsList = new ArrayList<>();
        numsList.add(3);
        numsList.add(20);
        numsList.add(-234);
        Set<Integer> numsSet = new HashSet<>();
//        can be added inside the constructor of set instead of assigning it later will also work
        numsSet.addAll(numsList);

        Set<Integer> treeSet = new TreeSet<>(); //for the sorted order retrival; even while running the for loop
        treeSet.add(numsList.get(0));
        treeSet.add(numsList.get(1));
        treeSet.add(numsList.getLast());
        for (int item:treeSet) {
            System.out.print(item + "**");
        }
        System.out.println();
//        order will be maintained in case of insertion ordering to be stored.
        Set<Integer> linkedHashset = new LinkedHashSet<>();
        linkedHashset.add(numsList.get(0));
        linkedHashset.add(numsList.getLast());
        linkedHashset.add(numsList.get(1));

        for (int item:linkedHashset) {
            System.out.print("--linkedHashSet: " + item);
        }
//        format of storage will be similar to array but in a linked list fashion for retreival and storage.
        List<Integer> arrlist = new ArrayList<>();
        List<Integer> arrList2 = new ArrayList<>(3);
        arrlist.add(10);
        arrlist.add(30);
        arrlist.add(56);
        int i = 0;
        for(int item:arrlist) {
            arrList2.add(item);
            i++;
            //        System.out.println(item);
        }
        System.out.println(arrList2);
        System.out.println(arrList2.get(0));
//    List<Integer> lists = new ArrayList<>();
//    Deque<String> arrayDeque = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Create a TreeSet with a reverse comparator
        Set<Integer> reverseSet = new TreeSet<>((a, b) -> b - a);

        // Add elements to the set
        reverseSet.add(10);
        reverseSet.add(5);
        reverseSet.add(30);
        reverseSet.add(20);

        // Elements are automatically sorted in descending order
        System.out.println("Elements in reverse order: " + reverseSet);
        Queue<Pair> que = new LinkedList<>(); //linked list declaration.

    }

    /*

        Array custom sorting
        Arrays.sort(A, Comparator.comparingInt((int[] row) -> row[0]) // First parameter
            .thenComparingInt(row -> row[1]));    // Second parameter for ties
    Arrays.sort(A, (a, b) -> {
    int firstComparison = Integer.compare(a[0], b[0]); // Compare by the first parameter
    return (firstComparison != 0) ? firstComparison : Integer.compare(a[1], b[1]); // If tie, compare by the second parameter
});
    Alternates
Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

Arrays.sort(events, (a, b) -> a[0] - b[0]);
Although a[0] - b[0] works in most cases, it is not safe for very large or very small integers because of possible overflow:

Example of Integer Overflow:
Suppose:

a[0] = Integer.MIN_VALUE; // -2^31
b[0] = Integer.MAX_VALUE; // 2^31 - 1
Then:

a[0] - b[0] = Integer.MIN_VALUE - Integer.MAX_VALUE = Overflow!
Using Integer.compare handles this case safely:

Integer.compare(a[0], b[0]);
*/


}
