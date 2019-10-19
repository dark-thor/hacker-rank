import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static boolean convert(String a, String b, int i, int j) {
        if (j == b.length()) {
            for (int k=i; k<a.length(); k++) {
                if (Character.isUpperCase(a.charAt(k))) {
                    return false;
                }
            }
            return true;
        }
        if (i == a.length() || (a.length()-i) < (b.length()-j)) {
            return false;
        }
        if (new Character(a.charAt(i)).equals(b.charAt(j))) {
            return convert(a, b, i+1, j+1);
        }
        if (new Character(Character.toUpperCase(a.charAt(i))).equals(b.charAt(j))) {
            return convert(a, b, i+1, j+1) || convert(a, b, i+1, j);
        }
        if (Character.isLowerCase(a.charAt(i))) {
            return convert(a, b, i+1, j);
        }
        return false;
    }

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        // if (convert(a,b,0,0))
        //    return "YES";
        // return "NO";
        boolean[][] valid = new boolean[b.length()+1][a.length()+1];
        valid[0][0] = true;
        for(int i=1; i<valid[0].length; i++) {
            if(Character.isLowerCase(a.charAt(i-1))) {
                valid[0][i] = valid[0][i-1];
            }
        }
        for (int i = 1; i < valid.length; i++) {
            for (int j = 1; j < valid[0].length; j++) {
                char ca = a.charAt(j - 1), cb = b.charAt(i - 1);
                if (Character.isUpperCase(ca)) {
                    if (ca == cb) {
                        valid[i][j] = valid[i-1][j-1];
                    }
                } else {
                    ca = Character.toUpperCase(ca);
                    if (ca == cb) {
                        valid[i][j] = valid[i-1][j-1] || valid[i][j-1];
                    } else {
                        valid[i][j] = valid[i][j-1];
                    }
                }
            }
        }
        return valid[b.length()][a.length()]? "YES": "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

