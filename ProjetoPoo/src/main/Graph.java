package main;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

public class Graph {
    Edge[][] matrix;
    int n;
    // Construtor para modo read
    public Graph(int nodes, int maxEdgeWeight){
        this.n = nodes;
        
        this.matrix = new Edge[n][n];
        initGraph();
    }

    // Construtor para modo file
    public Graph(int nodes){
        this.n = nodes;
        initGraph();
    }

    public void initGraph(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] = new Edge(0,0);
            }
        }
    }

    public void readGraph(String file){
        try{
            File f = new File(file);
            Scanner scanner = new Scanner(f);
            //Ignore First Line
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    this.matrix[i][j].weight =scanner.nextInt();
                }
            }

            scanner.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
    }

    public void createGraph(int n, int maxEdgeWeight){
        // Init
        int[] array = new int[n + 1];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        // Shuffle
        Random rand = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        array[n] = array[0];

        int nodeA, nodeB;

        for (int i = 0; i < n; i++) {
            nodeA = array[i];
            nodeB = array[i + 1];
            int edgeValue = rand.nextInt(maxEdgeWeight) + 1; // Generate a random value between 0 and 9 for the edge
            this.matrix[nodeA][nodeB].weight = edgeValue;
            this.matrix[nodeB][nodeA].weight = edgeValue; // Since the graph is undirected, assign the same value for the reverse edge
        }

        int additionalEdges = (int) (n / 3);
        for (int i = 0; i < additionalEdges; i++) {
            nodeA = rand.nextInt(n) + 1;
            nodeB = rand.nextInt(n) + 1;
            int edgeValue = rand.nextInt(maxEdgeWeight) + 1; // Generate a random value between 1 and maxEdgeWeight
            if (this.matrix[nodeA][nodeB].weight == 0 && this.matrix[nodeB][nodeA].weight == 0) {
                this.matrix[nodeA][nodeB].weight = edgeValue;
                this.matrix[nodeB][nodeA].weight = edgeValue; // Since the graph is undirected, assign the same value for the reverse edge
            } else {
                i--; // Retry adding an edge since there was already an edge present
            }
        }
    }

    @Override
    public String toString() {
        String printing = new String();
        for(int i=0;i<this.n;i++){
            for(Edge e : this.matrix[i]){
                printing = printing + e.weight + " ";
            }
            printing = printing + "\n";
        }
        return printing;
    }

    public void getAdjacent(int node){}
}