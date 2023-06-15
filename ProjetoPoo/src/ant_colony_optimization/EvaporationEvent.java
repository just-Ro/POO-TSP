package ant_colony_optimization;


import simulation.AEvent;


//Apos n movimentos, por cada edge do ciclo, criar um evento de evaporacao
//Simulacao a partir de n movimentos: if ph > 0 -> dar schedule da proxima evaporacao

public class EvaporationEvent extends AEvent{

    private double eta, rho;
    private int source, dest;
    private PheroGraph pGraph;
    private boolean isvalid = true;

    public EvaporationEvent(double time, double eta, double rho, int source, int dest, PheroGraph pGraph){
        super(time);
        this.eta = eta;
        this.rho = rho;
        this.dest = dest;
        this.source = source;
        this.pGraph = pGraph;

        this.eventTime += expRandom(eta);
    }

    @Override
    public void handleEvent() {
        System.out.println("Evaporou!" + eventTime);
        this.pGraph.updateEdge(source, dest, -this.rho);
        this.eventTime += expRandom(eta);

        if(this.pGraph.getEdge(source, dest) <= 0){
            this.isvalid = false;
        }

    }

    @Override
    public boolean valid() {
        return this.isvalid;
    }

}

