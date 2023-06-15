package ant_colony_optimization;

public interface IAnt {

    // verify function return to know if the travel went through or if there was no chosen node yet
    int travel(double eventTime);

    String getAntName();

    int getCurrentNode();

    int nextNode();

    int pathWeight();

    double pheroUpdateValue();

    void updatePheroGraph();

}