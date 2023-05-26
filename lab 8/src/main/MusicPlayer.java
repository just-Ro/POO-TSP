package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicPlayer{
    private Map<String,IFormatStrategy> formats;
    private Map<String,IPlayOrderStrategy> playOrders;
    private IFormatStrategy formatStrat;
    private IPlayOrderStrategy playOrderStrat;

    public MusicPlayer(){
        this.formats = new HashMap<>();
        this.formats.put("MP3", new Mp3FormatStrategy());
        this.formats.put("WAV", new WavFormatStrategy());
        this.formats.put("FLAC", new FlacFormatStrategy());
    }

    public void play(List<String> playlist){
        // ordenar a lista de acordo com o playOrderStrategy
        playlist = playOrderStrat.getOrder(playlist);

        // iterar sobre a list
        for(String track : playlist){
            // descobrir o formato
            // alterar o formatStrat para o formato correto
            // dar play
            formatStrat.processAudio(track);
        }
        
    }

    public void setFormatStrat(String strat){
        this.formatStrat = this.formats.get(strat);
    }

    public void setPlayOrderStrat(String strat){
        this.playOrderStrat = this.playOrders.get(strat);
    }

    public void insertFormatStrat(String format, IFormatStrategy strat){
        this.formats.put(format, strat);
    }

    public void insertPlayOrderStrat(String order, IPlayOrderStrategy strat){
        this.playOrders.put(order, strat);
    }

}