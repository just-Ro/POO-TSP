package musicplayer;

import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class AudioPlayer {
    private AudioFormatStrategy audioFormatStrategy;
    private PlayOrderStrategy playOrderStrategy;
	
    private Map<String, AudioFormatStrategy> formatStrategies = new HashMap<>();
    private Map<String, PlayOrderStrategy> orderStrategies = new HashMap<>();
    
    public AudioPlayer() {}

    public void play(List<String> audioFiles) {
			
		if (playOrderStrategy == null)
        	throw new IllegalArgumentException("Play order not set!");
				
        List<String> playOrder = playOrderStrategy.getOrder(audioFiles);
        for (String audioFile : playOrder) {
			
			String format = audioFile.substring(audioFile.lastIndexOf(".")+1,audioFile.length()); 
			format = format.toUpperCase();
        	
			audioFormatStrategy = formatStrategies.get(format);
        	if (audioFormatStrategy == null)
            	throw new IllegalArgumentException("Unsupported audio format: " + format);
			
            audioFormatStrategy.play(audioFile);
        }
    }
	
    public void setFormatStrategy(String s, AudioFormatStrategy formatStrategy) {
        formatStrategies.put(s,formatStrategy);
    }
	
    public void setPlayOrderStrategy(String s, PlayOrderStrategy orderStrategy) {
        orderStrategies.put(s,orderStrategy);
    }
	
    public void setPlayOrder(String s) {
        playOrderStrategy = orderStrategies.get(s.toUpperCase());
       	if (playOrderStrategy == null)
            throw new IllegalArgumentException("Unsupported Play order: " + s);
    }
}

