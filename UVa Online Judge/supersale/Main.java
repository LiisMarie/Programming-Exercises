import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static class Object {
        int price;  // P
        int weight;  // W

        public Object(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCasesAmount = Integer.parseInt(reader.readLine());  // T  - amount of test cases

        for (int testCase = 0; testCase < testCasesAmount; testCase++) {

            int numberOfObjects = Integer.parseInt(reader.readLine());  // N  - amount of objects

            Object[] objects = new Object[numberOfObjects + 1];  // create array for storing market objects

            for (int i = 1; i <= numberOfObjects; i++) {
                String[] line = reader.readLine().split(" ");  // get object
                objects[i] = new Object(Integer.parseInt(line[0]), Integer.parseInt(line[1]));  // add object to objects array
            }

            int numberOfPeople = Integer.parseInt(reader.readLine());  // G  - amount of people in the group
            int[] peopleMaxWeights = new int[numberOfPeople];  // MW  - i-th person maximal weight that they can carry

            int maxWeightToCarry = 0;  // store the max value amongst all people
            for (int i = 0; i < numberOfPeople; i++) {
                int currentWeight = Integer.parseInt(reader.readLine());  // get i-th person max weight to carry
                peopleMaxWeights[i] = currentWeight;  // save it to values

                if (currentWeight > maxWeightToCarry) maxWeightToCarry = currentWeight; // set new max, if necessary
            }

            // numberOfObjects + 1  X  maxWeightToCarry + 1
            int[][] valuesMatrix = new int[numberOfObjects + 1][maxWeightToCarry + 1];

            // go through all objects
            for (int i = 1; i <= numberOfObjects; i++) {
                Object object = objects[i];  // get i-th object

                // go through all weights until the maxWeight that can be carried
                for (int j = 1; j <= maxWeightToCarry; j++) {

                    if (j >= object.weight) {
                        // if current weight >= objects weight then get the max possible value
                        valuesMatrix[i][j] = Math.max(
                                object.price + valuesMatrix[i - 1][j - object.weight], // objects price + the price of last object(s) which weight stays under current weight
                                valuesMatrix[i - 1][j]);  // previous rows value
                    } else {
                        // if objects weight exceeds current weight then use the last rows value
                        valuesMatrix[i][j] = valuesMatrix[i - 1][j];
                    }
                }
            }

            int[] resultRow = valuesMatrix[numberOfObjects];  // get the final row
            long maxValueOfGoods = 0;  // for storing the max value
            for (int i = 0; i < numberOfPeople; i++) {
                // go through all people and get everyone's max value based on the weight that they can carry
                maxValueOfGoods += resultRow[peopleMaxWeights[i]];
            }

            System.out.println(maxValueOfGoods);
        }
    }
}
