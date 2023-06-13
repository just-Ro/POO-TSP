package main;

import java.util.*;
import ant_colony_optimization.*;
import graph.*;
import simulation.*;
/* Como compilar o projeto
 * 
 * Entrar na pasta certa:
 * cd src
 * 
 * Compilar tudo:
 * javac main/*.java ant_colony_optimization/*.java simulation/*.java graph/*.java
 * 
 * Criar o executável:
 * jar cmf manif.txt project.jar main/* ant_colony_optimization/* simulation/* graph/*
 * 
 * Correr o executável:
 * java -jar project.jar
 */

public class Main{

    // possivelmente passar classe Args pra aqui flr com stora !!!
    public static void main(String[] args) throws Exception {
        clearScreen();
        System.out.println("Program started");
        
        // debug without command line arguments
        String[] customArgs = initCustomArgs("generate");

        Args params = new Args(customArgs);   // Parse command line arguments

        WeightGraph graph = new WeightGraph();
        graph.insertGraphCreationStrat("generate", new GraphGeneratorStrategy());
        graph.insertGraphCreationStrat("read file", new GraphReaderStrategy());
        graph.setGraphCreationStrat(params.mode);
        graph.createGraph(params.nodes, params.maxEdgeWeight, params.file);
    
        Colony col = new Colony(graph, params.colonySize,params.nestNode, params.nodes, params.alfa,params.beta, params.pheromoneLevel,params.eta,params.rho);

        Simulator sim = new Simulator(params.finalInstant);
        init(params,col, sim);

        sim.run();
        // Above is main's last command
    }

    public static void init(Args params, Colony col, Simulator sim){
        for (Ant fromiga : col.ants){
            IEvent ev = new MoveEvent(0, fromiga, params.delta);
            sim.addToPEC(ev);
        }
        IEvent ev = new TimeEvent(0, params.finalInstant);
        sim.addToPEC(ev);
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static String[] initCustomArgs(String mode){
        if(mode.equals("generate")){
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
        }else{
            String[] customArgs = new String[12];
            customArgs[0] = new String("-f");
            customArgs[1] = new String("test.txt");
            return customArgs;
        }
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
