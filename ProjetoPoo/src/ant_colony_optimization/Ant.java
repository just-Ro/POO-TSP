package ant_colony_optimization;

import java.util.List;
import java.util.ArrayList;
import graph.WeightedGraph;
import rand.CustomRandom;
import rand.RandomSingleton;
import simulation.IEvent;

public class Ant implements IAnt{
    @Override
    public String toString() {
        return "\nAnt [name=" + name + ", " + path + "]" + "\ncurrent node = " + currentNode + "\tnext node = " + nextNode + "\n";
    }

    private int currentNode = -1;
    private int nextNode = -1;
    private String name;

    private Path path;
    private int pathSize=0;
    private boolean hamiltonian=false;

    private WeightedGraph graph;
    private PheroGraph phero;
    private Colony col;

    public Ant(int n1, WeightedGraph graph, PheroGraph phero, Colony col){
        this.path = new Path(n1);
        this.currentNode = n1;
        this.nextNode = n1;
        Names names = new Names();
        this.name = names.setName();
        // initialized by reference
        this.graph=graph;
        this.phero=phero;
        this.col = col;
        System.out.println(this);
    }

    // verify function return to know if the travel went through or if there was no chosen node yet
    @Override
    public int travel(double eventTime){
        if(this.currentNode==this.nextNode)
            return -1;
        this.pathSize += 1;
        path.add(this.pathSize, this.nextNode);
        this.currentNode = this.nextNode;
        if(this.hamiltonian){
            for(int i=0; i<this.pathSize; i++){
                phero.updateEdge(path.get(i), path.get(i+1), 0);
                if(phero.getEdge(i,i+1)==0){
                    IEvent ev = new EvaporationEvent(eventTime, col.getEta(), col.getRho(),i,i+1,phero);
                    //FALTA ADICIONAR A PEC
                }
                
            }
            updatePheroGraph();
            path.clearPath(0,this.pathSize);
        }
        this.hamiltonian=false;
        return 0;
    }

    @Override
    public String getAntName(){
        return this.name;
    }

    @Override
    public int getCurrentNode(){
        return this.currentNode;
    }

    private double edgeChance(int node){
        double edgeValue = (double) graph.getEdge(currentNode, node);
        phero.addEdge(currentNode, node, 0.0);
        double pheromoneValue = phero.getEdge(currentNode, node);
        // (alfa+pheromones)/(beta+weight)
        double chance = (col.getAlpha()+pheromoneValue)/(col.getBeta()+edgeValue);
        return chance;
    }

    @Override
    public int nextNode(){
        int i=1, j=0;
        boolean cicle = false;
        List<Integer> next = new ArrayList<>();
        List<Double> chance = new ArrayList<>();

        // only chooses a next node after traveling
        if(nextNode!=currentNode || hamiltonian){
            return nextNode;
        }
        // considera todos os vizinhos pelos quais nao tenha passado
        for(int dest : graph.getNeighbours(currentNode)){
            if(!path.contains(dest)){
                next.add(next.size(), dest);
                chance.add(chance.size(),edgeChance(dest)); 
            }
        }

        // se nao tiver nenhum no novo escolhe um pelo qual ja tenha passado
        if(next.isEmpty()){
            for(int dest : graph.getNeighbours(currentNode)){
                next.add(next.size(), dest);
                chance.add(next.size(),edgeChance(dest)); 
            }
            cicle=true;
        }
        CustomRandom random = RandomSingleton.getInstance();
        nextNode = random.weightedRandom(chance);
        if(cicle){
            // confirm if it is Hamiltonian
            if(path.get(pathSize)==path.get(0) && pathSize==col.getNodes()){
                hamiltonian = true;
            } else {
                for(j=0; j<pathSize; j++){
                    if(path.get(j)==i){
                        path.clearPath(j+1,pathSize);
                        break;
                    }
                }
            }
        }
        return nextNode++;
    }

    /* public void initPheroPath(){
        for(int i=0; i<pathSize; i++){
            phero.updateEdge(path.get(i), path.get(i+1), 0);
        }
    } */

    @Override
    public int pathWeight(){
        int w=0;

        for(int i=0; i<pathSize; i++){
            w += graph.getEdge(path.get(i),path.get(i+1));
        }

        return w;
    }

    @Override
    public double pheroUpdateValue(){
        return col.getGama()*graph.getW()/pathWeight();
    }

    @Override
    public void updatePheroGraph(){
        double pheroValue = pheroUpdateValue();
        for(int i=0; i<pathSize; i++){
            phero.updateEdge(path.get(i),path.get(i+1),pheroValue);
        }
    }

    public int edgeWeight(){
        if(graph.hasEdge(currentNode, nextNode))
            return graph.getEdge(currentNode,nextNode);
        return -1;
    }
}