import java.util.*;

public class ThreeSortedArrays {
    public static List<Integer> intersection(int[] arr1, int[] arr2, int[] arr3) {
        int i=0, j=0, k=0;
        List<Integer> result = new ArrayList<>();

        while (i<arr1.length && j<arr2.length && k<arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++; j++; k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }

    public static void main(String args[]){
        int[] arr1 = {0, 1, 3, 5, 11, 13, 13, 22};
        int[] arr2 = {0, 5, 11, 13, 13, 22};
        int[] arr3 = {0, 2, 3, 5, 12, 13, 13, 15, 22};
        System.out.println(Arrays.toString(intersection(arr1, arr2, arr3).toArray()));
    }
}

