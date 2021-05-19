import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner for getting input
        int linesAmount = scanner.nextInt();  // get user input and save it as amount of lines

        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();  // create instance of customly made queue

        // run for loop as many times as user defined earlier
        for (int i = 0; i < linesAmount; i++) {
            int action = scanner.nextInt(); // get action (1,2,3) to determine what to do
            if (action == 1) {
                // Enqueue element  into the end of the queue.
                int inputNumber = scanner.nextInt();
                queue.enqueue(inputNumber);
            } else if (action == 2) {
                queue.dequeue(); // Dequeue the element at the front of the queue.
            } else if (action == 3) {
                System.out.println(queue.peek()); // Print the element at the front of the queue.
            }
        }
        scanner.close(); // close scanner
    }

    public static class QueueUsingTwoStacks {
        // two stacks that are used for queue implementation
        private Stack<Integer> stack1 = new Stack();
        private Stack<Integer> stack2 = new Stack();

        public void enqueue(Integer toEnqueue) {
            stack1.push(toEnqueue);  // enqueue to the first queue
        }

        public void dequeue() {
            if ((stack1.size() + stack2.size()) == 0) return;  // if stacks are empty then there's nothing to dequeue
            preparations();
            stack2.pop();  // pop/remove the element in front of the queue
        }

        public Integer peek() {
            if ((stack1.size() + stack2.size()) == 0) return null;  // if stacks are empty then there's nothing to do
            preparations();
            return stack2.peek();  // see whats the first element in stack2 and return it
        }

        private void preparations() {
            if (stack2.isEmpty()) {  // stack2 has to be empty, otherwise that would mess up order
                // add all stack1 elements to stack2
                while (!stack1.isEmpty()) stack2.push(stack1.pop());
            }
        }
    }
}
