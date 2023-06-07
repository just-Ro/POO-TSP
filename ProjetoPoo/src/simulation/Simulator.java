package simulation;

import java.sql.Time;

public class Simulator {
    
    PEC pec = new PEC();
    double simulationTime;
    currentEvent=
    currentTime=

    //Inicializacao - 1 evento na PEC por cada formiga na colonia
    //Apos n movimentos, por cada edge do ciclo, criar um evento de evaporacao
    //Simulacao a partir de n movimentos: if ph > 0 -> dar schedule da proxima evaporacao



    //Eventos: Movimento, Evaporacao, /20 do tempo

    public Simulator(double simulationTime){
        this.simulationTime=simulationTime;
        while(currentTime<simulationTime){

            //Simulate current event
            currentEvent = pec.nextEvPEC();
            currentEvent = pec.nextEvPEC();
        }
    }


    public static double expRandom(double m) {
        double next = random.nextDouble();
        return -m*Math.log(1.0-next);
    }

}