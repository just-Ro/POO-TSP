package main;

public class PlayList{

    public void createPL(String firstMusic, String[] playlist){
        playlist[0] = firstMusic;
    }

    public void addMusic(String music, String[] playlist){
        int i = numMusic(playlist);
        playlist[i]=music;
    }

    public void rmMusic(String music, String[] playlist){
        int i = musicNum(music,playlist);
        while(playlist[i]!=null){
            playlist[i]=playlist[i+1];
            i++;
        }
    }

    public int numMusic(String[] playlist){
        int i=0;
        while(playlist[i]!=null){
            i++;
        }
        return i;
    }

    public int musicNum(String music, String[] playlist){
        int i=0;
        while(playlist[i]!=music){
            i++;
        }
        return i;
    }
}