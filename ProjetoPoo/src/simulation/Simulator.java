package simulation;

import java.util.*;

import ant_colony_optimization.*;
import main.Args;
import graph.*;

public class Simulator {
    
    PEC pec;
    double simulationTime;
    IEvent currentEvent;
    double currentTime;
    Colony col;
    double delta;
    WeightGraph wGraph;
    Args params;
    //Inicializacao - 1 evento na PEC por cada formiga na colonia
    //Apos n movimentos, por cada edge do ciclo, criar um evento de evaporacao
    //Simulacao a partir de n movimentos: if ph > 0 -> dar schedule da proxima evaporacao
    //Eventos: Movimento, Evaporacao, /20 do tempo
    
    public Simulator(Args params, Colony col, WeightGraph wGraph){
        this.params=params;
        this.simulationTime = params.finalInstant;
        this.col = col;
        this.currentTime = 0;
        this.delta = params.delta;
        this.wGraph = wGraph;
        Init();
        this.pec = new PEC();
        while(this.currentTime < this.simulationTime){ 
            //Simulate current event
            currentEvent = pec.nextEventPEC();
            currentEvent.handleEvent();
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
            Ant fromiga = col.ants.get(i);
            int dest = fromiga.nextNode(params.nestNode,params.alfa,params.beta);
            IEvent ev = new MoveEvent(this.currentTime+expRandom(delta*this.wGraph.getEdge(params.nestNode, dest)));
            pec.addEventPEC(ev);
        }
        for (i=0; i < 20; i++){
            IEvent ev = new TimeEvent(this.currentTime + (this.simulationTime*i)/20);
            pec.addEventPEC(ev);
        }
    }
    

}