package main;

public class WavFormatStrategy implements IFormatStrategy{
    public void processAudio(String audio){
        System.out.println("Playing " + audio + " in Wav format.");
    }
}