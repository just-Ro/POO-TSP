package main;
import java.util.Arrays;
import musicplayer.*;

public class Main {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
		
        player.setFormatStrategy("MP3", new MP3FormatStrategy());
        player.setFormatStrategy("WAV", new WAVFormatStrategy());
        player.setFormatStrategy("FLAC", new FLACFormatStrategy());
		
		player.setPlayOrderStrategy("NORMAL", new NormalPlayOrderStrategy());
		player.setPlayOrderStrategy("SHUFFLE", new ShufflePlayOrderStrategy());
		player.setPlayOrderStrategy("REPEAT", new RepeatPlayOrderStrategy());
		
		player.setPlayOrder("NORMAL");
        player.play(Arrays.asList("song1.mp3", "song2.wav", "song3.flac")); //playlist 1
		player.setPlayOrder("SHUFFLE");
        player.play(Arrays.asList("song1.wav", "song2.flac", "song3.wav")); //playlist 2
		player.setPlayOrder("REPEAT");
        player.play(Arrays.asList("song1.flac", "song2.mp3", "song3.flac")); //playlist 3
    }
}
