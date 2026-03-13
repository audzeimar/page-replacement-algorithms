import java.util.*;

public class SecondChance implements PageReplacementAlgorithm{
    private static class Page{
        int number;
        boolean referenceBit;

        Page(int number){
            this.number = number;
            this.referenceBit = true;
        }
    }

    public int runSimulation(List<Integer> referenceString, int frameCount){
        List<Page> frames = new LinkedList<>();
        int pointer = 0;
        int pageFaults = 0;

        for (int pageNumber : referenceString) {
            boolean hit = false;
            for (Page page : frames) {
                if(page.number == pageNumber){
                    page.referenceBit = true;
                    hit = true;
                    break;
                }
            }
            if(!hit){
                pageFaults++;
                if ( frames.size() < frameCount ) {
                    frames.add(new Page(pageNumber));
                } else {
                    while (true){
                        Page page = frames.get(pointer);
                        if (!page.referenceBit) {
                            frames.set(pointer, new Page(pageNumber));
                            pointer = (pointer + 1) % frameCount;
                            break;
                        } else {
                            page.referenceBit = false;
                            pointer = (pointer + 1) % frameCount;
                        }
                    }
                }
            }
        }
        return pageFaults;
    }
}
