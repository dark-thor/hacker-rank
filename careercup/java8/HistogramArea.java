import java.util.*;

public class HistogramArea {
    public static long maxAreaHistogram(long[] heights) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        long maxArea = 0;
        int n = heights.length;
        long[] width = new long[n];
        Arrays.fill(width, 1);
        for (int i=0; i < n; i++) {
            // check bars to left that are greater in heights
            while(!left.isEmpty() && heights[i] <= heights[left.peek()]) {
                left.pop();
            }
            if (left.isEmpty()) {
                // all elements to left are shorter than height[i]
                width[i] += i;
            } else {
                // height[left.peek()] is closest shorter height.
                width[i] += i - left.peek() - 1;
            }
            left.push(i);
        }
        for (int i=n-1; i >= 0; i--) {
            // check bars to right that are greater in heights
            while(!right.isEmpty() && heights[i] <= heights[right.peek()]) {
                right.pop();
            }
            if (right.isEmpty()) {
                // all elements to right are shorter than height[i]
                width[i] += n - 1 - i;
            } else {
                // height[right.peek()] is closest shorter height.
                width[i] += i - right.peek() - 1;
            }
            right.push(i);
        }
        for (int i=0; i<n; i++) {
            maxArea = Math.max(maxArea, width[i]*heights[i]);
        }
        return maxArea;
    }

    public static void main(String args[]){
        long[] heights = {2, 1, 3, 5, 1, 3, 3};
        System.out.println(maxAreaHistogram(heights));
    }
}

