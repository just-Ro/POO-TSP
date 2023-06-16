package ant_colony_optimization;

import java.util.List;
import java.util.ArrayList;
import graph.WeightedGraph;
import rand.ICustomRandom;
import rand.RandomSingleton;
import simulation.IEvent;

/**
 * Represents an Ant object that implements the IAnt interface.
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class Ant implements IAnt {
    @Override
    public String toString() {
        return "Ant [name=" + name + ", " + path + "]" + "\ncurrent node = " + currentNode + "\tnext node = " + nextNode + "\n";
    }

    private int currentNode = -1;
    private int nextNode = -1;
    private String name;

    private Path path;
    private boolean hamiltonian=false;

    private WeightedGraph graph;
    private PheroGraph phero;
    private Colony col;

    /**
     * Constructs an Ant object with the specified parameters.
     *
     * @param n1    The initial node for the Ant.
     * @param graph The WeightedGraph object for the Ant to navigate.
     * @param phero The PheroGraph object for the Ant to update pheromones.
     * @param col   The Colony object to which the Ant belongs.
     */
    public Ant(int n1, WeightedGraph graph, PheroGraph phero, Colony col){
        this.path = new Path(n1,graph);
        this.currentNode = n1;
        this.nextNode = n1;
        Names names = new Names();
        this.name = names.setName();
        // initialized by reference
        this.graph=graph;
        this.phero=phero;
        this.col = col;
        //System.out.println(this);
    }

    // verify return value to know if the travel went through or if there was no chosen node yet

    @Override
    public void travel(double eventTime, List<IEvent> newEvents){
        col.incrementMevent();
        path.size();
        path.add(path.size(), this.nextNode);
        //System.out.println("Caminho " + path);
        this.currentNode = this.nextNode;
        
        if(this.hamiltonian){
            col.updateScoreBoard(new Pair(this.name, this.path.copy()));
            //System.out.println("ciclo hamiltoniano encontrado!");
            for(int i=0; i<path.size()-1; i++){
                /* if(!phero.hasEdge(path.get(i), path.get(i+1)))
                    phero.addEdge(path.get(i), path.get(i+1), 0.0); */
                //If the value of Pheromones was 0, we need to create a new evaporation Event
                if(phero.getEdge(path.get(i), path.get(i+1))==0){
                    IEvent ev = new EvaporationEvent(eventTime, col.getEta(), col.getRho(),path.get(i),path.get(i+1),phero, col);
                    newEvents.add(ev);
                }
                
            }
            updatePheroGraph();
            //System.out.println(phero);
            path.clearUntil(1);
        }
        this.hamiltonian=false;
        //System.out.println(phero);
    }


    @Override
    public String getAntName(){
        return this.name;
    }


    @Override
    public int getCurrentNode(){
        return this.currentNode;
    }

    @Override
    public Path getPath(){
        return path;
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

        boolean cicle = false;
        List<Integer> next = new ArrayList<>();
        List<Double> chance = new ArrayList<>();

        // only chooses a next node after traveling
        if(nextNode!=currentNode || hamiltonian){
            return nextNode;
        }

        // consider all non-visited neighbours
        for(int dest : graph.getNeighbours(currentNode)){
            if(!path.contains(dest)){
                next.add(next.size(), dest);
                chance.add(chance.size(),edgeChance(dest)); 
            }
        }

        // if all neighbours were visited, consider all neighbours
        if(next.isEmpty()){
            for(int dest : graph.getNeighbours(currentNode)){
                next.add(next.size(), dest);
                chance.add(chance.size(),edgeChance(dest));
            }
            cicle=true;
            //System.out.println(cicle);
        }

        // get the next node based on the chance array
        ICustomRandom random = RandomSingleton.getInstance();
        nextNode = next.get(random.weightedRandom(chance));
        
        //System.out.println("CurrentNode: " + currentNode);
        //System.out.println("nextNode: " + nextNode);
        //System.out.println("next: " + next);
        //System.out.println("path: " + path);

        if(cicle){
            // confirm if it is Hamiltonian
            if(nextNode==path.get(0) && path.size()==col.getNodes()){
                hamiltonian = true;
            } else {
                for(int i=0; i<path.size();i++){
                    if(path.get(i)==nextNode){
                        path.clearUntil(i);
                        break;
                    }
                }
            }
        }
        return nextNode;
    }

    /* public void initPheroPath(){
        for(int i=0; i<pathSize; i++){
            phero.updateEdge(path.get(i), path.get(i+1), 0);
        }
    } */



    @Override
    public double pheroUpdateValue(){
        return col.getGama()*graph.getW()/path.pathWeight();
    }


    @Override
    public void updatePheroGraph(){
        double pheroValue = pheroUpdateValue();
        for(int i=0; i<path.size()-1; i++){
            phero.updateEdge(path.get(i),path.get(i+1),pheroValue);
        }
    }

    @Override
    public int edgeWeight(){
        if(graph.hasEdge(currentNode, nextNode))
            return graph.getEdge(currentNode,nextNode);
        return -1;
    }

}