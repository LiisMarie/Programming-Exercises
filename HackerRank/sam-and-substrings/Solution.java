import java.util.*;

public class Solution {

    static int substrings(String n) {
        int MOD = (int) Math.pow(10, 9) + 7;

        int[] numbersList = stringToNumbersArray(n);

        int length = numbersList.length;
        for (int i = length - 2; i >= 0; --i){
            numbersList[i] = (int) ((numbersList[i + 1] + (((long) numbersList[i]) * (length - i)) % MOD) % MOD);
        }

        int power = 1;
        int result = 0;
        for (int i : numbersList) {
            result = (int) ((result + (((long) i) * power) % MOD) % MOD);
            power = (int) ((power * 10L) % MOD);
        }

        return result;
    }

    private static int[] stringToNumbersArray(String n){
        int length = n.length();
        int[] numbers = new int[length];
        for (char c : n.toCharArray()){
            numbers[--length] = c - '0';
        }
        return numbers;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();

        int result = substrings(n);

        System.out.println(result);

        scanner.close();
    }
}
