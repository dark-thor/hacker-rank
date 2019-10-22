import java.util.*;
public class NestedListsMath {
  static long calculate(List<Object> list, long factor) {
      long sum = 0;
      if (list == null) return 0;
      for(Object item:list) {
          if (item instanceof ArrayList) {
              sum+=calculate((ArrayList)item, factor+1) * (factor+1);
          } else {
              sum+= (int)item * (factor+1);
          }
      }
      return sum;
  }
  public static void main(String args[]){
      List<Object> list = new ArrayList<Object>(){{
          add(8);
          add(3);
          add(2);
          add(new ArrayList<Object>(){{
            add(5);
            add(6);
            add(new ArrayList<Object>(){{
                add(9);
            }});
          }});
          add(6);
      }};
      long sum = calculate(list, 0);
      System.out.println(sum);
  }
}
