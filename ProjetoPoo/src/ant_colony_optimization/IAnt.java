package ant_colony_optimization;

import java.util.List;

import simulation.IEvent;

public interface IAnt {

    // verify function return to know if the travel went through or if there was no chosen node yet
    int travel(double eventTime, List<IEvent> newevents);

    String getAntName();

    int getCurrentNode();

    int nextNode();

    int pathWeight();

    double pheroUpdateValue();

    void updatePheroGraph();

}