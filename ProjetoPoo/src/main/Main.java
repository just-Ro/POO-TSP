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
 * javac main/*.java ant_colony_optimization/*.java simulation/*.java graph/*.java rand/*.java
 * 
 * Criar o executável:
 * jar cmf manif.txt project.jar main/* ant_colony_optimization/* simulation/* graph/* rand/*
 * 
 * Correr o executável:
 * java -jar project.jar
 * 
 * Remover todos .class files:
 * find . -name "*.class" -type f -exec rm -f {} +
 * (linux)
 */

 /**
  * The Main class represents the main entry point of the program.
  * It initializes the simulation and runs the simulator.
  * 
  * @author João Mateus 
  * @author Tiago Mira
  * @author Rodrigo Francisco
  */
public class Main{

    /**
     * The main method is the entry point of the program.
     * It initializes the simulation and runs the simulator based on the command line arguments.
     *
     * @param args the command line arguments
     * @throws Exception if an error occurs during the simulation
     */
    public static void main(String[] args) throws Exception {

        Args params = new Args(args);

        //Generate the Graph
        WeightedGraph graph = new WeightedGraph();
        graph.insertGraphCreationStrat("generate", new GraphGeneratorStrategy());
        graph.insertGraphCreationStrat("read file", new GraphReaderStrategy());
        graph.setGraphCreationStrat(params.mode);
        graph.createGraph(params.nodes, params.maxEdgeWeight, params.file);
    

        printProgramState(graph, params);
        //Create a colony of Ants
        Colony col = new Colony(graph, params.colonySize,params.nestNode, params.nodes, params.alfa,params.beta, params.pheromoneLevel, params.eta,params.rho);

        Simulator sim = new Simulator(params.finalInstant);
        
        //Initialize the first events
        init(params, col, sim);

        //Run the Simulator
        sim.run();


    }
    

    /**
     * Initializes the first events in the simulator.
     *
     * @param params the simulation parameters
     * @param col the ant colony
     * @param sim the simulator
     */
    public static void init(Args params, Colony col, Simulator sim){
        //For every Ant, one Move Event will be Created in time 0
        for (IAnt formiga : col.ants){
            IEvent ev = new MoveEvent(0, formiga, params.delta);
            sim.addToPEC(ev);
        }
        //A Time Event will also be created
        IEvent ev = new TimeEvent(params.finalInstant/20, params.finalInstant, col.getScoreBoard(),col);
        sim.addToPEC(ev);
    }

    /**
     * Prints the program state, including the input parameters and the graph.
     *
     * @param graph the weighted graph
     * @param params the simulation parameters
     */
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

    /**
     * The indentString method adds indentation to each line of a given string.
     *
     * @param string the string to be indented
     * @param spaces the number of spaces to be added as indentation
     * @return the indented string
     */
    public static String indentString(String string, int spaces){
        StringBuilder sb = new StringBuilder();
        String[] lines = string.split("\\r?\\n");

        for (String line : lines) {
            sb.append(" ".repeat(spaces));  // Add the desired number of spaces
            sb.append(line).append("\n");   // Append the original line with a newline character
        }

        return sb.toString();
    }

    /**
     * The clearScreen method clears the console screen.
     */
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    /**
     * The initCustomArgs method initializes and returns an array of custom command-line arguments based on the specified mode.
     *
     * @param mode The mode indicating the type of custom arguments to generate ("generate" or any other value)
     * @return An array of custom command-line arguments
     */
    public static String[] initCustomArgs(String mode){
        if(mode.equals("generate")){
            String[] customArgs = new String[12];
            customArgs[0] = new String("-r");
            customArgs[1] = new String("10");    // nodes
            customArgs[2] = new String("9");    // max weight
            customArgs[3] = new String("1");    // nest node
            customArgs[4] = new String("1.0");  // alpha
            customArgs[5] = new String("1.0");  // beta
            customArgs[6] = new String("0.2");  // delta
            customArgs[7] = new String("2.0");  // eta
            customArgs[8] = new String("10.0");  // rho
            customArgs[9] = new String("0.5");  // pheromone level
            customArgs[10] = new String("200");   // colony size
            customArgs[11] = new String("300.0"); // final instant
            return customArgs;
        }else{
            String[] customArgs = new String[12];
            customArgs[0] = new String("-f");
            customArgs[1] = new String("./TESTS/test.txt");
            return customArgs;
        }
    }
    
}

