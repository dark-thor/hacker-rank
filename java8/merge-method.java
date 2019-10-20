import java.util.*;
public class MergeMethod {
 
  public static void main(String args[]){
      int[] first = new int[] {1,3,6,7,0,0,0,0};
      int[] second = new int[] {0,2,3,4};
      int j = second.length-1;
      int i = first.length-second.length-1;
      int k = first.length-1;
      while (k >= 0) {
          if (i>=0 && (j<0 || first[i] > second[j])) {
              first[k] = first[i];
              k--; i--;
          } else {
              first[k] = second[j];
              k--; j--;
          }
      }
      System.out.println(Arrays.toString(first));
  }
}
