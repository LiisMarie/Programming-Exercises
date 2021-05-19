import java.util.*;

public class Solution {

    static int cookies(int k, PriorityQueue<Integer> pQueue) {
        int operationsAmount = 0;  // to keep track how many operations were necessary for sweet cookies
        // to keep track of queue size so that it doesn't have to be calculated in the beginning of every cycle
        int queueSize = pQueue.size();

        // while queue has atleast 2 elements and the topmost element is smaller than desired sweetness
        while (queueSize > 1 && pQueue.peek() <= k) {
            int newValue = pQueue.poll() + 2 * pQueue.poll();  // calculate new value, remove 2 topmost elements from queue
            pQueue.add(newValue);  // add new value to queue
            operationsAmount++;  // increase operations amount by one
            queueSize--;  // queue got smaller by one element, decrease
        }
        if (pQueue.peek() < k) return -1;  // if topmost element is smaller, then return -1
        return operationsAmount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        scanner.nextInt();

        int desiredSweetness = scanner.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();  // added priorityqueue straight here to make code faster

        while (scanner.hasNextInt()) {
            priorityQueue.add(scanner.nextInt());
        }

        System.out.println(cookies(desiredSweetness, priorityQueue));
    }
}
