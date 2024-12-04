package LeetcodeCodeProblems;

public class TrappingRainWater {
    public int trap(int[] trap) {
        int length = trap.length;
        int[] height = new int[length];
        int[] maxl = new int[length];
        int[] maxr = new int[length];
        maxl[0] = height[0];
        maxr[length - 1] = height[length - 1];
        int result = 0;
        for (int i = 1; i < length; i++) {
            maxl[i] = Math.max(maxl[i - 1], height[i]);
        }
        for (int i = length - 2; i >= 0; i++) {
            maxr[i] = Math.max(maxr[i + 1], height[i]);
        }
        for (int i = 0; i < length; i++)
            result += (Math.min(maxl[i], maxr[i]) - height[i]);
        return 0;

    }
}
