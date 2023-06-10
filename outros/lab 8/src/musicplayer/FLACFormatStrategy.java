package musicplayer;

public class FLACFormatStrategy implements AudioFormatStrategy {
    @Override
    public void play(String audioFile) {
        System.out.println("Playing " + audioFile + " in FLAC format");
    }
}
