package LeetcodeCodeProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Job {
    int startTime;
    int endTime;
    int profit;
    Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", profit=" + profit +
                '}';
    }
}

public class SortATupleofThreeElements {
    public static void main(String[] args) {
        int[] startTime = {1,2,3,4,6};
        int[] endTime = {3,5,10,6,9};
        int[] profit = {20,20,100,70,60};
        List<Job> tuple = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tuple.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        tuple.sort(Comparator.comparing(tupleVal -> tupleVal.startTime));

        for(Job item: tuple) {
            System.out.println(item);
        }
    }
}
