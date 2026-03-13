import java.util.*;

public class Simulation {

    public static void main(String[] args) {
        List<Integer> referenceString = generateReferenceString(10000,10);
        int frameCount = 4;

        List<PageReplacementAlgorithm> algorithms = List.of(
                new FIFO(),
                new OPT(),
                new LRU(),
                new SecondChance(),
                new RAND()
        );

        List<String> names = List.of("FIFO", "OPT", "LRU", "SecondChance", "RAND");
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Algorithm", "Page Faults", "Page Hits", "Time (ms)");

        for (int i = 0; i < algorithms.size(); i++) {
            PageReplacementAlgorithm algo = algorithms.get(i);
            long start = System.nanoTime();
            int faults = algo.runSimulation(referenceString, frameCount);
            long end = System.nanoTime();
            int hits = referenceString.size() - faults; //sytuacja, w której proces odwołuje się do strony, a ta już znajduje się w pamięci RAM
            long timeMs = (end - start) / 1_000_000; //czas potrzebny na wykonanie całej symulacji danego algorytmu

            System.out.printf("%-15s %-15d %-15d %-15d%n", names.get(i), faults, hits, timeMs);
        }
    }

    //generator losowego ciągu odwołań z lokalnością
    private static List<Integer> generateReferenceString(int length, int pages) {
        Random rand = new Random();
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int locality = rand.nextInt(100);
            if(locality < 80){
                sequence.add(rand.nextInt(pages/2)); // Często powtarzane
            } else {
                sequence.add(rand.nextInt(pages)); // Rzadziej używane
            }
        }
        return sequence;
    }
}
