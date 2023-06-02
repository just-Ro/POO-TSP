package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends PlayList{

    private String[][] playLists;
    private String music;

    public Main(int numb){
        createPL(music,playLists[numb]);
    }

    public int plNum(String[] playlist, String[][] playLists){
        int i=0;
        while(playLists[i]!=playlist){
            i++;
            if(playlist[i]==null)
                return -1;
        }
        return i;
    }

    public int numPl(String[][] playLists){
        int i=0;
        while(playLists[i]!=null){
            i++;
        }
        return i;
    }

    public static void insert(String[] args) {

        System.out.println("Enter playlist here : ");

        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String playlist = bufferRead.readLine();

            System.out.println(playlist);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


        System.out.println("Enter music here : ");

        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String music = bufferRead.readLine();

            System.out.println(music);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        

        if(plNum==-1){
            int i = numPl(playLists);
        }
    }
}