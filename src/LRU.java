import java.util.*;

public class LRU implements PageReplacementAlgorithm{
    public int runSimulation(List<Integer> referenceString, int frameCount) {
        LinkedHashMap<Integer, Integer> frames = new LinkedHashMap<>();
        int pageFaults = 0;

        for (int time = 0; time < referenceString.size(); time++) {
            int page = referenceString.get(time);
            if (!frames.containsKey(page)) {
                pageFaults++;
                if (frames.size() >= frameCount) {
                    int lruPage = Collections.min(frames.entrySet(), Map.Entry.comparingByValue()).getKey();
                    frames.remove(lruPage);
                }
            }
            frames.put(page,time);
        }
        return pageFaults;
    }
}
