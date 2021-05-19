import java.util.*;

public class Solution {

    static int luckBalance(int k, int[][] contests) {
        ArrayList<Integer> importantContests = new ArrayList<>(); // will store important contests luck balances

        int luck = 0;  // for computing luck

        for (int[] contest : contests) {
            int contestLuckBalance = contest[0];
            if (contest[1] == 1) {
                // contest is important and will be added among important contests
                importantContests.add(contestLuckBalance);
            } else {
                // contest isn't important so Lena can lose
                luck += contestLuckBalance;
            }
        }

        Collections.sort(importantContests, Collections.reverseOrder()); // sort contests, highest importance first

        for (int i = 0; i < importantContests.size(); i++){
            if (i < k) {
                // to maximize luck, Lena has to lose the contests with highest luck balance
                luck += importantContests.get(i);
            } else {
                // all left important contests must be won
                luck -= importantContests.get(i);
            }
        }

        return luck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        System.out.println(result);

        scanner.close();
    }
}
