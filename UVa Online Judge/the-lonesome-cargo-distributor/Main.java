import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // create scanner for receiving input

        int setsAmount = scanner.nextInt();  // get amount of sets

        while (setsAmount > 0) {  // do loop as many times as many sets there will be
            setsAmount--;  // decrease amount of sets

            // get necessary data
            int numberOfStations = Integer.parseInt(scanner.next());     // N
            int cargoCarrierCapacity = Integer.parseInt(scanner.next()); // S
            int maxCargoesPlatformB = Integer.parseInt(scanner.next());  // Q

            // list for stations that contains linked list of each stations cargoes destination stations
            ArrayList<LinkedList<Integer>> stations = new ArrayList<>();

            int sumOfCargoes = 0;  // total amount of cargoes

            // runs once for each station
            for (int i = 0; i < numberOfStations; i++) {
                int numberOfCargoesQueued = scanner.nextInt();  // gets number of cargoes in the station
                sumOfCargoes += numberOfCargoesQueued;  // adds the amount of cargoes to total sum
                LinkedList<Integer> cargoesDestinationStations = new LinkedList<>();  // for cargoes destination stations

                // go through all queued cargos
                while (numberOfCargoesQueued > 0) {
                    cargoesDestinationStations.add(scanner.nextInt() - 1);  // get cargos destination station
                    numberOfCargoesQueued--;  // decrease the amount of queued cargos so that all input can be collected
                }
                stations.add(cargoesDestinationStations);  // add destination stations list to stations
            }

            LinkedList<Integer> cargoCarrier = new LinkedList<>(); // create LinkedList to keep track of cargo carrier
            int currentPosition = 0;  // for storing the index of station that is currently under observation
            int spentTime = 0;

            // do until all cargo has reached its destination
            while (true) {
                while (cargoCarrier.size() > 0) {
                    // cargo carrier isn't empty so unload cargo
                    if (cargoCarrier.getLast() == currentPosition) {
                        cargoCarrier.removeLast();
                        sumOfCargoes -= 1;
                    } else if (stations.get(currentPosition).size() < maxCargoesPlatformB) {
                        // if platform B has not reached its full capacity yet, add cargoes to it
                        stations.get(currentPosition).addLast(cargoCarrier.removeLast());
                    } else {
                        break;
                    }
                    spentTime += 1; // each successful unload acquires 1 minute
                }

                while (stations.get(currentPosition).size() > 0 && cargoCarrier.size() < cargoCarrierCapacity) {
                    // if current station has any cargo and cargo carrier isn't full, then add cargo to the carrier
                    cargoCarrier.addLast(stations.get(currentPosition).removeFirst());
                    spentTime += 1;  // each successful load acquires 1 minute
                }

                currentPosition += 1; // move to another station
                if (currentPosition == numberOfStations) currentPosition = 0;  // start again at first station

                if (sumOfCargoes == 0) {
                    // if sum of cargoes reaches zero, then all cargoes have reached their destination
                    System.out.println(spentTime);
                    break;
                }
                spentTime += 2;  //  it requires exactly 2 minutes to move from any station to its adjacent one
            }
        }
    }
}
