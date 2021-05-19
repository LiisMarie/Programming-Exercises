import java.util.*;

public class Solution {

    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] matchingStringsAmount = new int[queries.length];

        int currentPosition = 0;
        for (String query : queries) {
            int count = 0;
            for (String stringToCheck : strings) {
                if (stringToCheck.contains(query)) {
                    count++;
                }
            }
            matchingStringsAmount[currentPosition] = count;
            currentPosition++;
        }
        return matchingStringsAmount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int re : res) {
            System.out.println(re);
        }

        scanner.close();
    }
}
