import java.util.*;

public class Node {
 
  public static void main(String args[]){
      LinkedList<Integer> first = new LinkedList<>();
      LinkedList<Integer> second = new LinkedList<>();
      first.add(1);
      first.add(9);
      first.add(9);
      second.add(1);
      second.add(1);
      LinkedList<Integer> result = new LinkedList<>();
      Integer carry = 0;
      Integer l = first.size() > second.size()? first.size():second.size();
      for (int i=0; i<l; i++) {
          Integer digit1 = first.pollLast();
          Integer digit2 = second.pollLast();
          Integer sum = (digit1 == null? 0: digit1)+ (digit2 ==null? 0:digit2) + carry;
          result.push(sum>9? sum-10: sum);
          carry = sum>9? 1:0;
      }
      if (carry == 1) {
          result.push(carry);
      }
      for(Integer x : result) {
          System.out.print(x);
      }
  }
}
