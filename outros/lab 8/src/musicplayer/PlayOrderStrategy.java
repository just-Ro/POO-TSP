package musicplayer;

import java.util.List;

public interface PlayOrderStrategy {
    List<String> getOrder(List<String> audioFiles);
}
