import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // create three stacks where to keep values
        Stack<Integer> s1 = new Stack<Integer>(), s2 = new Stack<Integer>(), s3 = new Stack<Integer>();
        // create variables to store each stacks current (and finally total) heights
        int totalHeight1 = 0, totalHeight2 = 0, totalHeight3 = 0;

        // as stacks are given in list where first element is the topmost and last element is the lowest
        // for example [3, 2, 1, 1, 1], then it's necessary to start from the end of the list
        // heights are added up and pushed into the stack that will look like this -> (top) 8 5 3 2 1 (bottom)
        for (int i = h1.size() - 1; i >= 0; i--) {
            totalHeight1 += h1.get(i);
            s1.push(totalHeight1);
        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            totalHeight2 += h2.get(i);
            s2.push(totalHeight2);
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            totalHeight3 += h3.get(i);
            s3.push(totalHeight3);
        }

        while (true) {
            // if any of the stack is empty, return 0 as it's the only way their height can be equal
            if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) return 0;
            // save each stacks topmost element as the stacks height
            totalHeight1 = s1.peek();
            totalHeight2 = s2.peek();
            totalHeight3 = s3.peek();

            // if equal height has been reached then the answer is found
            if (totalHeight1 == totalHeight2 && totalHeight2 == totalHeight3) return totalHeight1;

            // first stack is the highest, so remove the topmost element from it
            if (totalHeight1 >= totalHeight2 && totalHeight1 >= totalHeight3) {
                s1.pop();
            } else if (totalHeight2 >= totalHeight1 && totalHeight2 >= totalHeight3) {
                s2.pop();
            } else {
                s3.pop();
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        System.out.println(result);

        bufferedReader.close();
    }
}
