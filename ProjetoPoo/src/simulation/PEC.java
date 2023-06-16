package simulation;

import java.util.TreeSet;
import java.util.Comparator;


/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class PEC implements IPEC {
    private TreeSet<IEvent> eventSet;

    public PEC(){
        //this.eventSet = new TreeSet<>(Comparator.comparingDouble(IEvent::getEventTime));
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
        if (i == 0) i = -1;
        return i; 
    }
    
}
