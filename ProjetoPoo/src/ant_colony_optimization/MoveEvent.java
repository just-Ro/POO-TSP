package ant_colony_optimization;


import simulation.AEvent;


public class MoveEvent extends AEvent{

    private Ant formiga;
    private double delta;
    

    public MoveEvent(double time, Ant formiga, double delta){
        super(time);
        this.formiga = formiga;
        this.delta = delta;
        formiga.nextNode();
        this.eventTime += expRandom(delta*formiga.edgeWeight());
    }
    


    @Override
    public void handleEvent() {
        formiga.travel(eventTime);
        formiga.nextNode();
        //Programar proximo move Event
        this.eventTime += expRandom(delta*formiga.edgeWeight());
    }
}
