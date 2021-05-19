import java.text.DecimalFormat;

public class Main {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    private static String getAsPrice(int number) {
        return DECIMAL_FORMAT.format(number / 100.0);
    }

    public static void main(String[]args) {
        String answer = "";  // for storing answer

        // to make calculations easier, 20.00€ has been multiplied by 100
        for (int first = 1; first * 4 <= 2000; first++) {  // get first number
            // first number can be used if first * 4 <= 2000 because otherwise we would go over 20€ limit

            int second;
            for (second = first; first + second * 3 <= 2000; second++) {  // get second number
                // second number can be used if first + second * 3 <= 2000 because otherwise we would go over 20€ limit

                for (int third = second; first + second + 2 * third <= 2000; third++) {  // get third number
                    // third number can be used if first + second + 2 * third <= 2000 because otherwise we would go over 20€ limit

                    int sum = first + second + third;  // find sum of three prices
                    int product = first * second * third;  // find the product of three prices

                    if (product > 1000000) {

                        int fourth = (sum * 1000000) / (product - 1000000);  // calculate fourth product

                        // has to be in increasing order
                        // has to stay in 20€ limit
                        // sum and product have to be even
                        if (fourth >= third
                                && second + third + first + fourth <= 2000
                                && (first + second + third + fourth) * 1000000 == first * second * third * fourth) {

                            // add current solution to the final answer
                            answer += getAsPrice(first) + " " + getAsPrice(second) + " " + getAsPrice(third) + " " + getAsPrice(fourth) + "\n";
                        }
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
