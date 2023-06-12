package simulation;

import ant_colony_optimization.Ant;

public class MoveEvent implements IEvent{

    private Double eventTime;
    public String eventType = "Move";
    public Ant formiga;
    private Double alfa, beta, delta;
    private Integer nodes;
    public PEC pec;

    public MoveEvent(Double time, Ant formiga, Integer nodes, Double alfa, Double beta, Double delta, PEC pec){
        this.eventTime = time;
        this.formiga = formiga;
        this.alfa=alfa;
        this.beta=beta;
        this.nodes = nodes;
        this.delta = delta;
        this.pec = pec;
    }
    
    @Override
    public double getEventTime(){
        return eventTime;
    }


    @Override
    public void handleEvent() {
        formiga.travel(0);
        int dest = formiga.nextNode(nodes, alfa,beta);
        //Programar proximo move Event
        this.eventTime += expRandom(delta*); //COLOAR EDGE!
        //IEvent ev = new MoveEvent(this.eventTime+expRandom(delta*formiga.getCurrentNode()), formiga,nodes,alfa,beta,delta);
        pec.addEventPEC(this);
        
    }

    @Override
    public void updateSimulationState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSimulationState'");
    }
    
}
