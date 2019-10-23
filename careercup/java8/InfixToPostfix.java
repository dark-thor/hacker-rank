import java.util.*;
public class InfixToPostfix {

  static String infixToPostfix(String s) {
      Map<Character,Integer> op = new HashMap<>();
      // Set operator precedence
      op.put('-', 1);
      op.put('+', 2);
      op.put('/', 3);
      op.put('*', 4);
      op.put('^', 5);
      Stack<Character> stack = new Stack<>();
      StringBuffer sb = new StringBuffer();
      for (char c:s.toCharArray()) {
          if (op.containsKey(c)) {
              if (stack.isEmpty() || op.get(stack.peek()) < op.get(c)) {
                  stack.push(c);
              } else {
                  while(!stack.isEmpty() && op.get(stack.peek()) >= op.get(c)) {
                      Character ch = stack.pop();
                      sb.append(ch);
                  }
                  stack.push(c);
              }
          } else {
            sb.append(c);
          }
      }
      while(!stack.isEmpty()) {
          Character ch = stack.pop();
          sb.append(ch);
      }
      return sb.toString();
  }
  public static void main(String args[]){
      String s = "1*3+5/6";
      System.out.println(infixToPostfix(s));
  }
}
