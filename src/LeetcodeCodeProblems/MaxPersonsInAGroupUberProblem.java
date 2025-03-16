package LeetcodeCodeProblems;

import java.util.ArrayList;
import java.util.List;

public class MaxPersonsInAGroupUberProblem {
    public static void main(String[] args) {
        int[][] constraints = {{1, 2}, {2, 2}, {2, 3}, {3, 3}, {2, 2}};
        Result result = getMaxGroup(constraints);
        System.out.println("Max group size: " + result.maxSize);
        System.out.println("Persons in group: " + result.persons);
    }

    public static Result getMaxGroup(int[][] constraints) {
        int n = constraints.length;
        int maxGroupSize = 0;
        List<Integer> bestGroup = new ArrayList<>();

        // Iterate through all possible group sizes
        for (int size = 1; size <= n; size++) {
            List<Integer> currentGroup = new ArrayList<>();

            // Attempt to select 'size' people who fit the constraints
            for (int i = 0; i < n; i++) {
                int minRequired = constraints[i][0];
                int maxAllowed = constraints[i][1];
                if (minRequired <= size - 1 && size - 1 <= maxAllowed) {
                    currentGroup.add(i + 1); // Storing 1-based index
                }
            }

            // Check if the current group is valid and update the best group
            if (currentGroup.size() >= size) {
                maxGroupSize = size;
                bestGroup = new ArrayList<>(currentGroup.subList(0, size));
                System.out.println(currentGroup);
            }
        }

        return new Result(maxGroupSize, bestGroup);
    }
}

// Class to hold the result of the max group size and the list of person indices
class Result {
    int maxSize;
    List<Integer> persons;

    public Result(int maxSize, List<Integer> persons) {
        this.maxSize = maxSize;
        this.persons = persons;
    }
}