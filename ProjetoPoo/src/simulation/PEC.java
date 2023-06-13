package simulation;

import java.util.*;

public class PEC {
    // Pending Event Container
    //ArrayList<Event> eventList;
    private TreeSet<IEvent> eventSet;

    public PEC(){
        //this.eventList = new ArrayList<>();
        this.eventSet = new TreeSet<>(Comparator.comparingDouble(IEvent::getEventTime));
    }

    public void addEventPEC(IEvent ev){
        //adicionar um sort
        this.eventSet.add(ev);
    }

    public IEvent nextEventPEC() {
        IEvent firstEvent = eventSet.pollFirst();
        return firstEvent;
    }

}
