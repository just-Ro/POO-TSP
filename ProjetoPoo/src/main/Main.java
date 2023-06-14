package main;

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
        
        // debug without command line arguments
        String[] customArgs = initCustomArgs("generate");

        Args params = new Args(customArgs);   // Parse command line arguments

        WeightedGraph graph = new WeightedGraph();
        graph.insertGraphCreationStrat("generate", new GraphGeneratorStrategy());
        graph.insertGraphCreationStrat("read file", new GraphReaderStrategy());
        graph.setGraphCreationStrat(params.mode);
        graph.createGraph(params.nodes, params.maxEdgeWeight, params.file);
    
        printProgramState(graph, params);

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

    public static void printProgramState(WeightedGraph graph, Args params){

        String topic1 = new String("Input parameters:");

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%6d", params.nodes)).append(" : number of nodes in the graph\n");
        builder.append(String.format("%6d", params.nestNode)).append(" : the nest node\n");
        builder.append(String.format("%6.2f", params.alfa)).append(" : alpha, ant move event\n");
        builder.append(String.format("%6.2f", params.beta)).append(" : beta, ant move event\n");
        builder.append(String.format("%6.2f", params.delta)).append(" : delta, ant move event\n");
        builder.append(String.format("%6.2f", params.eta)).append(" : eta, pheromone evaporation event\n");
        builder.append(String.format("%6.2f", params.rho)).append(" : rho, pheromone evaporation event\n");
        builder.append(String.format("%6.2f", params.pheromoneLevel)).append(" : pheromone level\n");
        builder.append(String.format("%6d", params.colonySize)).append(" : ant colony size\n");
        builder.append(String.format("%6.2f", params.finalInstant)).append(" : final instant");
        String topic2 = builder.toString();

        String topic3 = new String("with graph:");
        
        String topic4 = graph.toString();

        builder = new StringBuilder();
        builder.append(indentString(topic1, 0));
        builder.append(indentString(topic2, 13));
        builder.append("\n");
        builder.append(indentString(topic3, 8));
        builder.append(indentString(topic4, 20));
        System.out.println(builder.toString());
    }

    public static String indentString(String string, int spaces){
        StringBuilder sb = new StringBuilder();
        String[] lines = string.split("\\r?\\n");

        for (String line : lines) {
            sb.append(" ".repeat(spaces));  // Add the desired number of spaces
            sb.append(line).append("\n");   // Append the original line with a newline character
        }

        return sb.toString();
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static String[] initCustomArgs(String mode){
        if(mode.equals("generate")){
            String[] customArgs = new String[12];
            customArgs[0] = new String("-r");
            customArgs[1] = new String("8");    // nodes
            customArgs[2] = new String("9");    // max weight
            customArgs[3] = new String("1");    // nest node
            customArgs[4] = new String("1.0");  // alpha
            customArgs[5] = new String("1.0");  // beta
            customArgs[6] = new String("1.0");  // delta
            customArgs[7] = new String("1.0");  // eta
            customArgs[8] = new String("1.0");  // rho
            customArgs[9] = new String("1.0");  // pheromone level
            customArgs[10] = new String("1");   // colony size
            customArgs[11] = new String("300.0"); // final instant
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
