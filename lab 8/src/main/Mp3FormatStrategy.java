package main;

public class Mp3FormatStrategy implements IFormatStrategy{
    public void processAudio(String audio){
        System.out.println("Playing " + audio + " in Mp3 format.");
    }
}