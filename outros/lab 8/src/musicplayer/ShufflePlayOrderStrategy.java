package musicplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShufflePlayOrderStrategy implements PlayOrderStrategy {
    @Override
    public List<String> getOrder(List<String> audioFiles) {
    	System.out.println("Playing in shuffle order...");
        List<String> shuffledOrder = new ArrayList<>(audioFiles);
        Collections.shuffle(shuffledOrder);
        return shuffledOrder;
    }
}
