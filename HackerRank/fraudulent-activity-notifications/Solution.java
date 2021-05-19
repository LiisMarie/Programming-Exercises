import java.util.*;

public class Solution {

    static int activityNotifications(int[] expenditure, int d) {
        int expenditureSize = expenditure.length;
        if (expenditureSize <= d) return 0;  // insufficient transaction data

        int countNotifications = 0;  // for storing notifications amount

        double median;
        PriorityQueue<Integer> max = new PriorityQueue<>(); // stores bigger numbers (will use the min value from it)
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());  // stores smaller numbers (will use max value from it)

        // add one value to each queue
        if (expenditure[0] < expenditure[1]) {
            min.add(expenditure[0]);
            max.add(expenditure[1]);
        } else {
            max.add(expenditure[0]);
            min.add(expenditure[1]);
        }

        // starting at index 2 because first 2 elements have been added
        for (int i = 2; i < expenditureSize - 1; i++) {
            // if current element is smaller than the smallest element of max queue, it'll be added to min queue
            if (expenditure[i] < max.peek()) {
                min.add(expenditure[i]);
            } else {
                max.add(expenditure[i]);
            }

            balanceQueues(min, max);

            int maxSize = max.size();
            int minSize = min.size();
            // when we have enough data stored, it can be checked whether the notification has to be sent or not
            if (maxSize + minSize == d) {
                if (d % 2 == 0) {
                    // queues are even so take topmost from both and divide by 2
                    median = (min.peek() + max.peek()) / 2.0;
                } else if (minSize > maxSize) {
                    median = min.peek();
                } else {
                    median = max.peek();
                }

                // increase the amount of notifications sent
                if (2 * median <= expenditure[i + 1]) countNotifications++;

                // remove the first element
                int elementToRemove = expenditure[i - d + 1];
                // it has to be removed only once, so when removing from max fails (it's not there)
                // then remove from min
                if (!max.remove(elementToRemove)) min.remove(elementToRemove);
            }
        }

        return countNotifications;
    }

    // balancing queues is necessary so that we can retrieve the middle element for median
    public static void balanceQueues(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
        // depending on which queue is bigger, remove the topmost element from it and add to the other queue
        if (max.size() - min.size() > 1) {
            min.add(max.poll());
        } else if (min.size() - max.size() > 1) {
            max.add(min.poll());
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(result);

        scanner.close();
    }
}
