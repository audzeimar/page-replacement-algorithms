import java.util.*;

public class OPT implements PageReplacementAlgorithm{

    public int runSimulation(List<Integer> referenceString, int frameCount){
        Set<Integer> frames = new HashSet<>();
        int pageFaults = 0;

        for (int i = 0; i < referenceString.size(); i++){
            int page = referenceString.get(i);
            if (!frames.contains(page)){
                pageFaults++;
                if(frames.size()>=frameCount){
                    int pageToRemove = -1;
                    int farthestUse = -1;

                    for (int p : frames){
                        int nextUse = Integer.MAX_VALUE;
                        for(int j = i + 1; j < referenceString.size(); j++){
                            if (referenceString.get(j) == p){
                                nextUse = j;
                                break;
                            }
                        }
                        if(nextUse > farthestUse){
                            farthestUse = nextUse;
                            pageToRemove = p;
                        }
                    }
                    frames.remove(pageToRemove);
                }
                frames.add(page);
            }
        }
        return pageFaults;
    }
}
