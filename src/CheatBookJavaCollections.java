import java.util.*;

class Pair {
    int i, j;
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
        for (int item : treeSet) {
            System.out.print(item + "**");
        }
        System.out.println();
//        order will be maintained in case of insertion ordering to be stored.
        Set<Integer> linkedHashset = new LinkedHashSet<>();
        linkedHashset.add(numsList.get(0));
        linkedHashset.add(numsList.getLast());
        linkedHashset.add(numsList.get(1));

        for (int item : linkedHashset) {
            System.out.print("--linkedHashSet: " + item);
        }
//        format of storage will be similar to array but in a linked list fashion for retreival and storage.
        List<Integer> arrlist = new ArrayList<>();
        List<Integer> arrList2 = new ArrayList<>(3);
        arrlist.add(10);
        arrlist.add(30);
        arrlist.add(56);
        int i = 0;
        for (int item : arrlist) {
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
/*        Filling the Array with same values for initial run

        int[][] dp = new int[5][5];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        for (int[] rowItem: dp) {
            for (int val:rowItem) {
                System.out.print(val);
            }
            System.out.println();
        }*/

//        here primitive type integer is used instead of int hence this sorting is working fine.
//        Integer[] events =  new Integer[]{3,2,1,5,6,7,10};
//        Arrays.sort(events, (a, b) -> a - b);
//        System.out.println(Arrays.stream(events).toList().toString());

/*
//        Important Notes:
        Even though int[][] holds primitive int values, each row (int[]) is actually an object reference (an array reference).
	•	The outer array (int[][]) is an array of references to int[].
	•	Arrays.sort() with a comparator works on arrays of objects, and since each row (int[]) is an object reference, it can be sorted using a comparator.

✔ Key Insight: int[][] is not primitive at the top level—it’s an array of references (int[]), which allows sorting with a custom comparator.

⸻
*/
//        refer this sheet for sorting based on Arrays.sort method using the lambda and primitive arguments
        int[] events = new int[]{3, 2, 1, 5, 6, 7, 10};
        Integer[] arr = Arrays.stream(events).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> Integer.compare(a, b));
        System.out.println(Arrays.stream(arr).toList().toString());


//        int[][] sampleSort = new int[][]{{1,2},{3,6},{6,2},{2,9}};
//        Arrays.sort(sampleSort, (a, b)->{
//            return Integer.compare(a[0], b[0]);
//        });
//        for (int[] arr : sampleSort) {
//            System.out.print(arr[0] + " " + arr[1] + ", ");
//        }

    }


}
