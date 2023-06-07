package simulation;
import java.util.ArrayList;


public class PEC {
    // Pending Event Container
    ArrayList<Event> eventList;

    public PEC(){
        this.eventList = new ArrayList<>();
    }

    public void addEventPEC(Event ev){
        this.eventList.add(ev);
    }

    public Event nextEventPEC(){
        //remover primeiro evento da PEC e retornar-lo
        Event firstEvent = eventList.remove(0);
        return firstEvent;
    }

}
