import java.util.*;
public class SubArraySumWithFlip {

  static int subArraySumWithFlip(int arr[], int l, int r) {
      int max_so_far = Arrays.stream(arr).max().getAsInt();
      int max_sum = max_so_far;
      for (int i=0; i<l; i++) {
          max_so_far = Math.max(arr[i], max_so_far + arr[i]);
          max_sum = Math.max(max_sum, max_so_far);
      }
      for (int i=r; i>=l; i--) {
          max_so_far = Math.max(arr[i], max_so_far + arr[i]);
          max_sum = Math.max(max_sum, max_so_far);
      }
      for (int i=r+1; i<arr.length; i++) {
          max_so_far = Math.max(arr[i], max_so_far + arr[i]);
          max_sum = Math.max(max_sum, max_so_far);
      }
      return max_sum;
  }
  public static void main(String args[]){
      int[] arr = new int[]{5,-5,-2,4,1};
      System.out.println(subArraySumWithFlip(arr,0,2));
  }
}
