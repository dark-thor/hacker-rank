public class Solution {
  public static void main(String args[]){
      boolean[] valid = new boolean[1001];
      for (int i=0; i<=1000/10; i++) {
          for(int j=0; j<=1000/15; j++) {
              for (int k=0; k<=1000/55; k++) {
                  int sum = i*10+15*j+k*55;
                  if (sum <=1000) {
                      valid[sum] = true;
                  }
                  else
                      break;
              }
          }
      }
      for(int i=1; i<=1000; i++) {
          if (valid[i])
            System.out.println(i);
      }
  }
}
