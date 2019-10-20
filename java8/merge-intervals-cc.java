import java.util.*;
// Solution from careercup
public class MergeIntervals {
  public static List<int[]> mergeInterval(int[][] l1, int[][] l2) {
        int i =0, j =0;
        List<int []> result = new LinkedList<>();
        while(i < l1.length && j < l2.length){
            if(l2[j][1] > l1[i][0]){
                mergeWithResult(result, l1[i][0], l1[i][1]);
                i++;
            } else if(l1[i][1] > l2[j][0]){
                mergeWithResult(result, l2[j][0], l2[j][1]);
                j++;
            }
        }
        while (i < l1.length){
            mergeWithResult(result, l1[i][0], l1[i][1]);
            i++;
        }

        while (j < l2.length){
            mergeWithResult(result, l2[j][0], l2[j][1]);
            j++;
        }
        return result;
    }

    private static void mergeWithResult(List<int[]> result, int e1, int e2) {
        if(result.isEmpty())
            result.add(new int[]{e1,e2});
        else {
            int [] ar = result.get(result.size()-1);
            if(ar[1] < e1){
                result.add(new int[]{e1,e2});
            } else {
                int[] newAr = new int[2];
                newAr[0] = Integer.min(ar[0], e1);
                newAr[1] = Integer.max(ar[1], e2);
                result.remove(result.size() - 1);
                result.add(newAr);
            }
        }
    } 
  public static void main(String args[]){
      int[][] first = new int[][] {{1,3}, {4,7}};
      int[][] second = new int[][] {{3,4}, {7,9}};
      List<int[]> results = mergeInterval(first, second);
      for (int k=0; k<results.size(); k++)
          System.out.println(Arrays.toString(result.get(k)));
  }
}
