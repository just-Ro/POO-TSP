package ant_colony_optimization;

import java.util.ArrayList;
import java.util.List;


public class Colony {
    public List<Ant> ants;

    public Colony(double colonySize, int nestNode){
        this.ants = new ArrayList<Ant>();
        for(int i=0;i<colonySize;i++){
            ants.add(new Ant(nestNode));
        }
    }
}
