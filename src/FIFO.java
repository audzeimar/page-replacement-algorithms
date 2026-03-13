
import java.util.*;

public class FIFO implements PageReplacementAlgorithm{

    public int runSimulation(List<Integer> referenceString, int frameCount){
        Set<Integer> frames = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int pageFaults = 0;

        for (int page : referenceString) {
            if(!frames.contains(page)){
                pageFaults++;
                if(frames.size() == frameCount){
                    int removed= queue.poll();
                    frames.remove(removed);
                }
                frames.add(page);
                queue.add(page);
            }
        }
        return pageFaults;
    }
}
