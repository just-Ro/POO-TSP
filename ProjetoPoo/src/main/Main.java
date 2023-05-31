package main;

import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Program started!");
        Args params = new Args(args);   // Parse command line arguments
        
        if(params.readMode()){
            // Read mode
            System.out.println("modo -r");
            Graph graph = new Graph(params.n, params.a);

        }else if(params.fileMode()){
            // File mode
            Graph graph = new Graph(params.n);
            graph.readGraph(params.file);
            
        }


    }
}