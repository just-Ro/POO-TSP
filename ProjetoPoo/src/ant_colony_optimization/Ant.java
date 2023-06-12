package ant_colony_optimization;

import java.util.*;

import graph.*;

public class Ant{
    protected List<Integer> path;
    protected int pathSize=0;
    protected int currentNode = -1;
    private String name;

    public Ant(int n1){
        this.path = new ArrayList<Integer>();
        path.add(n1);
        currentNode=n1;
        Names names = new Names();
        name = names.setName();
    }

    public void travel(int node){
        path.add(pathSize, node);
        pathSize += 1;
        currentNode = node;
    }

    public String antName(){
        return name;
    }

    public void nextNode(AGraph<Integer,Double> graph, IMAgraph<Integer,Double> phero, Map<Integer, Map<Integer, Double> > map, int nodes, double alfa, double beta){
        int i=0, j=0, aux=0;
        boolean cicle = false;
        double totalChance = 0, currentChance = 0;
        List<Integer> next = new ArrayList<>();
        List<Double> chance = new ArrayList<>();
        
        // considera todos os nos existentes aos quais ele tenha uma edge e pelos quais nao tenha passado
        while(i<nodes){
            
            if(graph.hasEdge(currentNode-1,i)){
            // if(matrix[currentNode-1][i].getWeight()!=0){
                for(j=0; j<pathSize; j++){
                    if(path.get(j).equals(i)){
                        j=-1;
                        break;
                    }
                }
                if(j==-1) break;
                next.add(aux, i);
                double edgeValue = graph.getEdge(currentNode-1, i);
                double pheromoneValue = phero.getModValue(currentNode - 1, i);
                // (alfa+pheromones)/(beta+weight)
                chance.add(aux,(alfa+pheromoneValue)/(beta+edgeValue));
                totalChance+=chance.get(aux);
                aux++;
            }
            i++;
        }
        // se nao tiver nenhum no pelo qual nao tenha passado escolhe um pelo qual ja tenha passado
        if(aux==0){
            while(i<nodes){
                if(graph.hasEdge(currentNode-1,i)){
                    next.add(aux, i);
                    double edgeValue = graph.getEdge(currentNode-1, i);
                    double pheromoneValue = phero.getModValue(currentNode - 1, i);
                    // (alfa+pheromones)/(beta+weight)
                    chance.add(aux,(alfa+pheromoneValue)/(beta+edgeValue));
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
        Random random = new Random();
        double choose = ( random.nextDouble() % 10000 ) / 100 ;
        for(i=0; i<aux; i++){
            if(choose<chance.get(i)){
                travel(next.get(i));
                break;
            }
        }
        // tem que retirar o ciclo criado // node escolhido armazenado na variavel 'i'
        if(cicle){
            for(j=0; j<pathSize; j++){
                if(path.get(j).equals(i)){
                    j++;
                    int k = j;
                    for(; j<pathSize; j++){
                        path.remove(j);
                    }
                    pathSize = k;
                    break;
                }
            }
        }
    }
}