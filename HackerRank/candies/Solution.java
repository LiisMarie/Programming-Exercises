import java.io.*;
import java.util.*;

public class Solution {

    static long candies(int n, int[] arr) {
        int arrSize = arr.length; // save arr size so it does not have to be found again

        int[] candies = new int[arrSize]; // create a list for storing candies
        // kid at index 4 gets as many candies as there are at index 4 in candies list
        candies[0] = 1;  // set candies amount for first kid, so that it can be compared later in the loop

        // go through in correct order
        for (int i = 1; i < arrSize; i++) {
            candies[i] = 1;  // set current to have 1 candy
            // if current kid has higher rating then current kid should have one more candy than the previous one
            if (arr[i] > arr[i - 1]) candies[i] = candies[i - 1] + 1;
        }

        // go through in reverse order
        for (int i = arrSize - 1; i > 0; i--) {
            // if previous kid has higher rating then current kid
            // then previous kid's candies amount should be raised if his current amount of candies isn't bigger
            // than is the amount of current kids candies + 1
            if (arr[i] < arr[i - 1]) candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
        }

        // go through the candies list and calculate the amount of candies needed
        long amountOfCandies = 0;
        for (int i= 0; i < arrSize; i++) {
            amountOfCandies += candies[i];
        }

        return amountOfCandies;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        System.out.println(result);

        scanner.close();
    }
}
