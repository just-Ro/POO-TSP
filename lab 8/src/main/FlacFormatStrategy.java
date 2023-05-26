package main;

public class FlacFormatStrategy implements IFormatStrategy{
    public void processAudio(String audio){
        System.out.println("Playing " + audio + " in Flac format.");
    }
}