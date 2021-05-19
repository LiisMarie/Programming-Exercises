import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(); // default stack
        Stack<Integer> maxStack = new Stack<Integer>(); // stack for max values

        Scanner scanner = new Scanner(System.in); // scanner for getting input
        int linesAmount = scanner.nextInt();  // get user input and save it as amount of lines

        // run for loop as many times as user defined earlier
        for (int i = 0; i < linesAmount; i++) {
            int action = scanner.nextInt(); // get action (1,2,3) to determine what to do
            if (action == 1) {
                // Push the element x into the stack.
                int inputNumber = scanner.nextInt(); // get element that will be pushed to stack
                stack.push(inputNumber);
                // if maxStack is currently empty or inputNumber is bigger than current max, then push it to maxStack
                if (maxStack.isEmpty() || inputNumber >= maxStack.peek()) {
                    maxStack.push(inputNumber);
                }
            } else if (action == 2) {
                // Delete the element present at the top of the stack.
                int removed = stack.pop();
                // if the topmost element is max element, then remove it from the maxStack
                if (removed == maxStack.peek()) {
                    maxStack.pop();
                }
            } else if (action == 3) {
                System.out.println(maxStack.peek()); // Print the maximum element in the stack.
            }
        }
        scanner.close(); // close scanner
    }
}
