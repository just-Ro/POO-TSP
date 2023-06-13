package ant_colony_optimization;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import graph.WeightGraph;

public class Ant{
    private int currentNode = -1;
    private int nextNode = -1;
    private String name;

    private List<Integer> path;
    private int pathSize=0;
    private boolean hamiltonian=false;

    private WeightGraph graph;
    private PheroGraph phero;
    private Colony col;

    public Ant(int n1, WeightGraph graph, PheroGraph phero){
        this.path = new ArrayList<Integer>();
        path.add(n1);
        this.currentNode = n1;
        Names names = new Names();
        this.name = names.setName();
        // initialized by reference
        this.graph=graph;
        this.phero=phero;
    }

    // verify function return to know if the travel went through or if there was no chosen node yet
    public int travel(){
        if(currentNode==nextNode)
            return -1;
        pathSize += 1;
        path.add(pathSize, nextNode);
        currentNode = nextNode;
        return 0;
    }

    public String getAntName(){
        return name;
    }

    public int getCurrentNode(){
        return currentNode;
    }
    
    public int nextNode(){
        int i=0, j=0, aux=0;
        boolean cicle = false;
        double totalChance = 0, currentChance = 0;
        List<Integer> next = new ArrayList<>();
        List<Double> chance = new ArrayList<>();

        // only chooses a next node after traveling
        if(nextNode!=currentNode && hamiltonian){
            return nextNode;
        }
        
        // considera todos os nos existentes aos quais ele tenha uma edge e pelos quais nao tenha passado
        while(i<col.getNodes()){
            
            if(graph.hasEdge(currentNode-1,i)){
                for(j=0; j<pathSize+1; j++){
                    if(path.get(j).equals(i)){
                        j=-1;
                        break;
                    }
                }
                if(j==-1) break;
                next.add(aux, i);
                double edgeValue = (double) graph.getEdge(currentNode-1, i);
                double pheromoneValue = phero.getEdge(currentNode - 1, i);
                // (alfa+pheromones)/(beta+weight)
                chance.add(aux,(col.getAlpha()+pheromoneValue)/(col.getBeta()+edgeValue));
                totalChance+=chance.get(aux);
                aux++;
            }
            i++;
        }
        // se nao tiver nenhum no pelo qual nao tenha passado escolhe um pelo qual ja tenha passado
        if(aux==0){
            while(i<col.getNodes()){
                if(graph.hasEdge(currentNode-1,i)){
                    next.add(aux, i);
                    double edgeValue = (double) graph.getEdge(currentNode-1, i);
                    double pheromoneValue = phero.getEdge(currentNode - 1, i);
                    // (alfa+pheromones)/(beta+weight)
                    chance.add(aux,(col.getAlpha()+pheromoneValue)/(col.getBeta()+edgeValue));
                    totalChance+=chance.get(aux);
                    aux++;
                }
                i++;
            }
            cicle=true;
        }
        // chance de 0 a 100
        for(i=0; i<aux-1; i++){
            chance.set(i,chance.get(i)/totalChance + currentChance);
            currentChance=chance.get(i);
        }
        chance.set(aux-1,100.00);
        // so com duas casas decimais
        for(i=0; i<aux; i++){
            chance.set(aux, Math.round(chance.get(i) * 100.0) / 100.0);
        }
        // escolhe aleatoriamente o proximo no
        Random random = RandomSingleton.getInstance();
        double choose = ( random.nextDouble() % 10000 ) / 100 ;
        for(i=0; i<aux; i++){
            if(choose<chance.get(i)){
                nextNode = i;
                break;
            }
        }
        // tem que retirar o ciclo criado // node escolhido armazenado na variavel 'i'
        if(cicle){
            // confirm if it is Hamiltonian
            if(path.get(pathSize)==path.get(0) && pathSize==col.getNodes()){
                hamiltonian = true;
            } else {
                // if not do this
                for(j=0; j<pathSize; j++){
                    if(path.get(j).equals(i)){
                        j++;
                        int k = j;
                        for(; j<pathSize+1; j++){
                            path.remove(k);
                        }
                        pathSize = k-1;
                        break;
                    }
                }
            }
        }
        return nextNode;
    }

    public int pathWeight(){
        int w=0;

        for(int i=0; i<pathSize; i++){
            w += graph.getEdge(path.get(i),path.get(i+1));
        }

        return w;
    }

    public double phero(){
        throw new UnsupportedOperationException("Unimplemented method 'phero'");
    }

    int edgeWeight(){
        return graph.getEdge(currentNode,nextNode);
    }
}