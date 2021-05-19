import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static class InstrumentGroup implements Comparable<InstrumentGroup> {
        Float peopleSharingScore; // = amountOfPeople / amountOfScores
        int amountOfPeople;
        int amountOfScores;

        InstrumentGroup(float peopleSharingScore, int amountOfPeople, int amountOfScores) {
            this.peopleSharingScore = peopleSharingScore;
            this.amountOfPeople = amountOfPeople;
            this.amountOfScores = amountOfScores;
        }

        void addOneScore() {
            amountOfScores++;  // add one score
            peopleSharingScore = (float) amountOfPeople / (float) amountOfScores;  // recalculate amount of people sharing
        }

        @Override
        public int compareTo(InstrumentGroup instrumentGroup) {
            // instrument groups have to be compared by peopleSharingScore
            return instrumentGroup.peopleSharingScore.compareTo(peopleSharingScore);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // create reader

        String line;
        while ((line = reader.readLine()) != null) {
            String[] list = line.split(" "); // split line, to get amount of scores allowed to buy

            int scoresAllowedToBuy = Integer.parseInt(list[0]);  // p - get amount of scores that we are allowed to buy

            PriorityQueue<InstrumentGroup> priorityQueue = new PriorityQueue<>();  // for storing instrument groups

            line = reader.readLine();  // get input of different instruments
            String[] differentInstrumentsAmounts = line.split(" ");  // split line, to get list of amounts

            for (String amount : differentInstrumentsAmounts) {
                int amountOfPeople = Integer.parseInt(amount);  // get amount of people playing current instrument

                // add one initial instrument
                priorityQueue.add(new InstrumentGroup(amountOfPeople, amountOfPeople, 1));

                scoresAllowedToBuy--; // one less score allowed to buy
            }

            // while we can buy more scores, we will do so
            while (scoresAllowedToBuy > 0) {
                // will take the instrument group with max people sharing one score and give one more score to them
                InstrumentGroup instrumentGroup = priorityQueue.poll(); // remove it from the queue
                if (instrumentGroup != null) {
                    instrumentGroup.addOneScore();  // add one score to the group
                    priorityQueue.add(instrumentGroup);   // add it back to the queue
                    scoresAllowedToBuy--;  // one less score to buy
                } else {
                    break;
                }
            }

            assert priorityQueue.peek() != null;
            int answer = (int) Math.ceil(priorityQueue.peek().peopleSharingScore);
            System.out.println(answer);  // get the max value of people sharing a score
        }
    }
}
