import java.util.*;

public class Solution {
    static String isBalanced(String s) {
        LinkedList<Character> visited = new LinkedList<Character>();  // store currently went through brackets
        Map<Character, Character> equivalentsMap  = new HashMap<Character, Character>() {{
            put(']', '[');
            put(')', '(');
            put('}', '{');
        }};  // map for getting corresponding bracket from
        List<Character> openingBrackets = Arrays.asList('[', '(', '{'); // save opening brackets to list

        // go through the string char by char
        for (Integer i = 0; i < s.length(); i++) {
            Character currentCharacter = s.charAt(i); // get char at position i
            // if bracket is an opening one, then add it to visited list
            if (openingBrackets.contains(currentCharacter)) {
                visited.addFirst(currentCharacter);
            } else {
                // closing bracket
                if (visited.size() != 0) {
                    Character lastVisitedCharacter = visited.removeFirst(); // remove first from the visited list
                    // if lastVisitedCharacter isn't the corresponding one to current one, then the string isn't balanced
                    if (lastVisitedCharacter != equivalentsMap.get(currentCharacter)) {
                        return "NO";
                    }
                } else {
                    // if there are no visited brackets yet, then it's not balanced
                    return "NO";
                }
            }
        }
        if (visited.size() != 0) return "NO"; // if all visited were not removed, then it's not balanced
        return "YES";  // if code reaches here then string is balanced
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }
        scanner.close();
    }
}
