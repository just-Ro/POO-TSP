package musicplayer;

import java.util.List;

public class NormalPlayOrderStrategy implements PlayOrderStrategy {
    @Override
    public List<String> getOrder(List<String> audioFiles) {
    	System.out.println("Playing in normal order...");
        return audioFiles;
    }
}
