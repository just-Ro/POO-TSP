package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

public class Graph {
    int[][] matrix;
    int n;
    public Graph(int nodes, int maxEdgeWeight){
        n = nodes;
        
        this.matrix = new int[n][n];
        
    }

    public Graph(int nodes){
        n = nodes;

    }

    public void readGraph(String file){
        try{
            File f = new File(file);
            Scanner scanner = new Scanner(f);
            //Ignore First Line
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] =scanner.nextInt();
                }
            }

            scanner.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
    }

    public void createGraph(int n, int maxEdgeWeight, int nestNode){
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

        for (int i = 0; i < n; i++) {
            int nodeA = array[i];
            int nodeB = array[i + 1];
            int edgeValue = rand.nextInt(maxEdgeWeigh) + 1; // Generate a random value between 0 and 9 for the edge
            matrix[nodeA][nodeB] = edgeValue;
            matrix[nodeB][nodeA] = edgeValue; // Since the graph is undirected, assign the same value for the reverse edge
        }
    }

}




/////////////////////////////////////////


public class Graph {
    // node of adjacency list 
    static class Node {
        int value, weight;
        Node(int value, int weight)  {
            this.value = value;
            this.weight = weight;
        }
    };
 
// define adjacency list
 
List<List<Node>> adj_list = new ArrayList<>();
 
    //Graph Constructor
    public Graph(List<Edge> edges)
    {
        // adjacency list memory allocation
        for (int i = 0; i < edges.size(); i++)
            adj_list.add(i, new ArrayList<>());

        // add edges to the graph
        for (Edge e : edges)
        {
            // allocate new node in adjacency List from src to dest
            adj_list.get(e.src).add(new Node(e.dest, e.weight));
        }
    }
// print adjacency list for the graph
    public static void printGraph(Graph graph)  {
        int src_vertex = 0;
        int list_size = graph.adj_list.size();
 
        System.out.println("The contents of the graph:");
        while (src_vertex < list_size) {
            //traverse through the adjacency list and print the edges
            for (Node edge : graph.adj_list.get(src_vertex)) {
                System.out.print("Vertex:" + src_vertex + " ==> " + edge.value + 
                                " (" + edge.weight + ")\t");
            }
 
            System.out.println();
            src_vertex++;
        }
    }
}