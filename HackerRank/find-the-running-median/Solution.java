import java.util.*;

public class Solution {

    static double[] runningMedian(int[] a) {
        PriorityQueue<Integer> max = new PriorityQueue<>(); // stores bigger numbers (will use the min value from it)
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());  // stores smaller numbers (will use max value from it)

        double median;

        double[] result = new double[a.length];  // for storing results
        result[0] = (double) a[0];  // add first element to results, no need to compute anything
        result[1] = (a[0] + a[1]) / 2.0;  // find median of first two elements

        // add one value to each queue
        if (a[0] < a[1]) {
            min.add(a[0]);
            max.add(a[1]);
        } else {
            max.add(a[0]);
            min.add(a[1]);
        }

        // starting at index 2 because first 2 elements have been added
        for (int i = 2; i < a.length; i++) {
            // if current element is smaller than the smallest element of max queue, it'll be added to min queue
            if (a[i] < max.peek()) {
                min.add(a[i]);
            } else {
                max.add(a[i]);
            }

            balanceQueues(min, max);

            int maxSize = max.size();
            int minSize = min.size();

            if (maxSize == minSize) {
                // queues are even so take topmost from both and divide by 2
                median = (min.peek() + max.peek()) / 2.0;
            } else if (minSize > maxSize) {
                median = min.peek();
            } else {
                median = max.peek();
            }

            result[i] = median;
        }
        return result;
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
        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (double v : result) {
            System.out.println(v);
        }
    }
}
