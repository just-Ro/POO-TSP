package simulation;

import java.util.*;

import ant_colony_optimization.*;
import main.Args;
import graph.*;

public class Simulator {
    
    PEC pec;
    double simulationTime;
    Event currentEvent;
    double currentTime;
    Colony col;
    double delta;

    //Inicializacao - 1 evento na PEC por cada formiga na colonia
    //Apos n movimentos, por cada edge do ciclo, criar um evento de evaporacao
    //Simulacao a partir de n movimentos: if ph > 0 -> dar schedule da proxima evaporacao
    //Eventos: Movimento, Evaporacao, /20 do tempo
    
    public Simulator(Args params, Colony col){

        this.simulationTime = params.finalInstant;
        this.col = col;
        this.currentTime = 0;
        this.delta = params.delta;
        Init();
        this.pec = new PEC();
        while(this.currentTime < this.simulationTime){
            
            //Simulate current event
            currentEvent = pec.nextEventPEC();
        }
    }
    

    static Random random = new Random();

    public static double expRandom(double m) {
        double next = random.nextDouble();
        return -m*Math.log(1.0-next);
    }

    public void Init(){
        int i;
        for (i = 0; i < col.ants.size(); i++) {
            //Ant fromiga = col.ants.get(i);
            Event ev = new Move(this.currentTime+expRandom(delta /*FALTA MULTIPLICAR PELO PESO DA EDGE*/));
            pec.addEventPEC(ev);
        }
        for (i=0; i < 20; i++){
            Event ev = new Time(this.currentTime + (this.simulationTime*i)/20);
            pec.addEventPEC(ev);
        }
    }

    

}