package graph;

public class Edge {
    int weight;
    double ph;

    public Edge(int weight, double pheromones){
        this.weight = weight;
        this.ph = pheromones;
    }

    public int getWeight(){
        return weight;
    }

    public double getPheromones(){
        return ph;
    }
}
