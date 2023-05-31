package main;

public class Edge {
    public int n1,n2,weight;
    public double ph;

    public Edge(int n1, int n2, int weight, double pheromones){
        this.n1 = n1;
        this.n2 = n2;
        this.weight = weight;
        this.ph = pheromones;
    }
}
