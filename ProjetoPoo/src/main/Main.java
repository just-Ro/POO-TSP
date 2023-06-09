package main;

import java.util.ArrayList;
import java.util.List;

import ant_colony_optimization.*;
import graph.*;
import simulation.*;
/* Como compilar o projeto
 * 
 * Entrar na pasta certa:
 * cd src
 * 
 * Compilar tudo:
 * javac main/*.java ant_colony_optimization/*.java discrete_stochastic_simulation/*.java graph/*.java
 * 
 * Criar o executável:
 * jar cmf manif.txt project.jar main/* ant_colony_optimization/* discrete_stochastic_simulation/* graph/*
 * 
 * Correr o executável:
 * java -jar project.jar
 */

public class Main{
    public static void main(String[] args) throws Exception {
        clearScreen();
        System.out.println("Program started");
        
        // debug without command line arguments
        String[] customArgs = initCustomArgs();

        Args params = new Args(customArgs);   // Parse command line arguments
        
        if(params.readMode()){
            // Read mode
            System.out.println("modo -r");
            MatrixGraph graph = new MatrixGraph(params.nodes, params.maxEdgeWeight);
            System.out.print(graph);

        }else if(params.fileMode()){
            // File mode
            MatrixGraph graph = new MatrixGraph(params.nodes);
            graph.readGraph(params.file);
        
        }

        Colony col = new Colony(params.colonySize,params.nestNode);
        Simulator sim = new Simulator(params, col);
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static String[] initCustomArgs(){
        String[] customArgs = new String[12];
        customArgs[0] = new String("-r");
        customArgs[1] = new String("5");
        customArgs[2] = new String("1");
        customArgs[3] = new String("1");
        customArgs[4] = new String("1");
        customArgs[5] = new String("1");
        customArgs[6] = new String("1");
        customArgs[7] = new String("1");
        customArgs[8] = new String("1");
        customArgs[9] = new String("1");
        customArgs[10] = new String("1");
        customArgs[11] = new String("1");
        return customArgs;
    }
    
}








//                                                 _____
//   											 _/ _ _ \_  
//   											(o / | \ o)
//   											 || o|o ||
//   											 | \_|_/ |
//   											 |  ___  |
//   											 | (___) |
//   											 |\_____/|
//   											 | \___/ |
//   											 \       /
//   											  \__ __/
