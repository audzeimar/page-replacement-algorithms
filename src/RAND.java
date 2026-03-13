import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RAND implements PageReplacementAlgorithm{
    @Override
    public int runSimulation(List<Integer> referenceString, int frameCount) {
        List<Integer> frames = new ArrayList<>();
        int faults = 0;
        Random rand = new Random();

        for (int page : referenceString) {
            if (!frames.contains(page)) {
                faults++;
                if (frames.size() >= frameCount) {
                    int indx = rand.nextInt(frameCount);
                    frames.set(indx, page);
                } else {
                    frames.add(page);
                }
            }
        }
        return faults;
    }
}
