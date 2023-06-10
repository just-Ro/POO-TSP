package musicplayer;

import java.util.ArrayList;
import java.util.List;

public class RepeatPlayOrderStrategy implements PlayOrderStrategy {
    @Override
    public List<String> getOrder(List<String> audioFiles) {
    	System.out.println("Playing in repeat order...");
        List<String> repeatedOrder = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            repeatedOrder.addAll(audioFiles);
        }
        return repeatedOrder;
    }
}
