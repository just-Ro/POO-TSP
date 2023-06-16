package simulation;

import java.util.TreeSet;
import java.util.Comparator;


/**
 * The PEC (Priority Event Container) class implements the IPEC interface and represents a container for events in a simulation.
 * It uses a TreeSet to store events in a sorted order based on their event time.
 * This class is responsible for adding events to the container, retrieving the next event, and checking if the container is empty.
 * 
 * Example usage:
 * PEC pec = new PEC();
 * IEvent event = new Event(...);
 * pec.addEventPEC(event);
 * IEvent nextEvent = pec.nextEventPEC();
 * 
 * Note: The actual implementation of the IEvent interface is not shown here.
 * The PEC class assumes that the IEvent interface and its implementing classes exist and have appropriate functionality.
 * 
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class PEC implements IPEC {
    private TreeSet<IEvent> eventSet;

    /**
     * Constructs a new PEC object.
     * Initializes the TreeSet to store events in a sorted order based on their event time.
     */
    public PEC(){
        this.eventSet = new TreeSet<>(new PECComparator());
    }

    @Override
    public void addEventPEC(IEvent ev){
        this.eventSet.add(ev);
    }

    @Override
    public IEvent nextEventPEC() {
        IEvent firstEvent = eventSet.pollFirst();
        return firstEvent;
    }

    @Override
    public boolean isEmpty(){
        return this.eventSet.isEmpty();
    }

}

class PECComparator implements Comparator<IEvent>{

    @Override
    public int compare(IEvent e1, IEvent e2) {
        int i = Double.compare(e1.getEventTime(), e2.getEventTime());
        //Dont return 0, so that TreeSet can have more than 1 event with the same Event Time
        if (i == 0) i = -1;
        return i; 
    }
    
}
