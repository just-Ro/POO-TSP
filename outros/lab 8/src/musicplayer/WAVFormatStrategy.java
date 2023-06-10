package musicplayer;

public class WAVFormatStrategy implements AudioFormatStrategy {
    @Override
    public void play(String audioFile) {
        System.out.println("Playing " + audioFile + " in WAV format");
    }
}
