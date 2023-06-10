package musicplayer;

public class MP3FormatStrategy implements AudioFormatStrategy {
    @Override
    public void play(String audioFile) {
        System.out.println("Playing " + audioFile + " in MP3 format");
    }
	
}