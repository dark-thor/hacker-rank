import java.util.*;
public class MergeIntervals {
 
  public static void main(String args[]){
      int[][] first = new int[][] {{1,3}, {4,7}};
      int[][] second = new int[][] {{3,4}, {7,9}};
      int i = 0, j = 0;
      int left, right;
      if (first[0][0] < second[0][0]) {
          left = first[0][0];
          right = first[0][1];
          i++;
      } else {
          left = second[0][0];
          right = second[0][1];
          j++;
      }
      int[][] result = new int[first.length+second.length][2];
      int result_count = 0;

      while (i < first.length || j<second.length) {
        // check if (left, right) intersects with first(i)[left, right]
        if (i< first.length && left <= first[i][1] && right >= first[i][0]) {
            right = Math.max(right, first[i][1]); i++;
        }
        // check if (left, right) intersects with first(i)[left, right]
        else if (j < second.length && left <= second[j][1] && right>= second[j][0]) {
            right = Math.max(right, second[j][1]); j++;
        }
        // doesn't intersect add (left, right) interval to results.
        else {
            result[result_count][0] = left;
            result[result_count][1] = right;
            result_count++;
            // reinitialize left, right
            if (i < first.length && (j>= second.length || first[i][0] < second[j][0])) {
                left = first[i][0];
                right = first[i][1];
                i++;
            } else {
                left = second[j][0];
                right = second[j][1];
                j++;
            }
        }      
      } // end while
      
      // check if (left, right) is already added to result.
      if (result_count==0 || (result_count > 0 && result[result_count][0]!=left)) {
        result[result_count][0] = left;
        result[result_count][1] = right;
        result_count++;
      }
      for (int k=0; k<result_count; k++)
          System.out.println(Arrays.toString(result[k]));
  }
}
