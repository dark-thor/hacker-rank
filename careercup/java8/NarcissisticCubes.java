/**
 * Find all the numbers the sum of cube of each digits is the number itself.
 *
 * @implNote the first thing that should be done is how to identify upper boundary for list of
 * numbers.
 *
 * If length == 1 (0 <= n < 9), then the max value of the sum of cubes will be 9*9*9 = 729
 *
 * If length == 2 (10 <= n < 100), then the max value of the sum of cubes will be 9*9*9*2 = 1458
 *
 * If length == 3 (100 <= n < 1000), then the max value of the sum of cubes will be 9*9*9*3 = 2187
 *
 * If length == 4 (1000 <= n < 10000), then the max value of the sum of cubes will be 9*9*9*4 =
 * 2916
 *
 * If length == 5 (10000 <= n < 100000), then the max value of the sum of cubes will be 9*9*9*5 =
 * 3645
 *
 * It means that for numbers with length equals to 4 there is a probability that it could be a
 * number with sum of cubes equals to that number, but for numbers with length that equals to 5,
 * it is not the case, expected sum will be less than a number all the time. So, we can use 10000 as
 * a upper boundary for the calculation.
 */

import java.util.*;
public class NarcissisticCubes {

  public static void main(String args[]){
      List<Integer> results = new ArrayList<>();
      for (int num=1; num<10000; num++) {
          int i = num;
          int sum = 0;
          while (i > 0) {
              int rem= i%10;
              sum+= rem*rem*rem;
              i = (i-rem)/10;
          }
          if (sum == num) {
              results.add(num);
          }
      }
      System.out.println(Arrays.toString(results.toArray()));

