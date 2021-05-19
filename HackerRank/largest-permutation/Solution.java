import java.util.*;

public class Solution {

    static int[] largestPermutation(int k, int[] arr) {
        int arrSize = arr.length;

        int[] index = new int[arrSize + 1]; // create array for storing elements indexes
        for (int i = 0; i < arrSize; i++) {
            index[arr[i]] = i;
        }

        for (int i = 0; i < arrSize; i++) {
            if (k <= 0) break;  // no more swaps left, end the loop
            if (arr[i] == arrSize - i) continue;

            // swap elements, current element takes the place, that is the best for it
            // other element goes to the index where current used to be
            arr[index[arrSize - i]] = arr[i];
            index[arr[i]] = index[arrSize - i];
            arr[i] = arrSize - i;
            index[arrSize - i] = i;
            k--; // decrease swaps
        }

        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = largestPermutation(k, arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }
}
