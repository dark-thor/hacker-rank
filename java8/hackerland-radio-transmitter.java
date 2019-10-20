import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int i=0;
        int count = 0;
        int center = 0, right = 0;
        // Perform greedy search
        while (i<x.length) {
            count++;
            // max position to cover current house
            center = x[i] + k; 
            // search for farthest house within range k (can do binary search for better performance)
            while (i<x.length && x[i] <= center) i++; 
            // transmitter at i-1
            right = x[i-1] + k; // right bound of transmitter at i-1
            // exclude all houses within right bound (can do binary search for better performance)
            while(i<x.length && x[i] <= right) i++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

