package ant_colony_optimization;

import java.util.List;
import java.util.ArrayList;
import graph.*;

public class Ant{
    protected List<Integer> path;
    protected int pathSize=0;
    protected int currentNode = -1;

    public Ant(int n1){
        this.path = new ArrayList<Integer>();
        path.add(n1);
        currentNode=n1;
    }

    public void travel(int node){
        path.add(node, null);
        pathSize += 1;
        currentNode = node;
    }

    public void chooseNextNode(Edge[][] matrix, int nodes, double alfa, double beta){
        int i=0, aux=0;
        double totalchance = 0;
        List<Integer> next = new ArrayList<>();
        List<Double> chance = new ArrayList<>();
        
        while(i<nodes){
            if(matrix[currentNode-1][i].getWeight()!=0){
                next.add(aux, i);
                // (alfa+pheromones)/(beta+weight)
                chance.add(aux,(alfa+matrix[currentNode-1][i].getPheromones())/(beta+matrix[currentNode-1][i].getWeight()));
                totalchance+=chance.get(aux);
                aux++;
            }
            i++;
        }
        for(i=0; i<aux; i++){
            chance.set(i,chance.get(i)/totalchance);
        }
    }
}