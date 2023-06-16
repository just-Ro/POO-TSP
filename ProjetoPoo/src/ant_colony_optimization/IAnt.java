package ant_colony_optimization;

import java.util.List;

import simulation.IEvent;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public interface IAnt {

    // verify function return to know if the travel went through or if there was no chosen node yet
    int travel(double eventTime, List<IEvent> newevents);

    String getAntName();

    /**This function 
     * @return
     */
    int getCurrentNode();

    int nextNode();

    double pheroUpdateValue();

    void updatePheroGraph();

}