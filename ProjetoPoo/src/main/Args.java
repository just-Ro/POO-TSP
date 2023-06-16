package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Args class parses and stores the command line arguments passed to the program.
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class Args implements IArgs{

    public int nodes, maxEdgeWeight, nestNode, colonySize;
    public double alfa, beta, delta, eta, rho, pheromoneLevel, finalInstant;
    public String file;
    public String mode;

    /**
     * Constructs an Args object and processes the command line arguments.
     *
     * @param args the command line arguments
     */
    public Args(String[] args){
        if(args.length < 2){
            System.out.println("Not enough command line arguments.");
            System.exit(0);
        }

        String option = args[0];
        if (option.equals("-r")) {
            if(args.length < 12){
                System.out.println("Not enough command line arguments.");
                System.exit(0);
            }
            this.readFromArgs(args);;
            
        }else if(option.equals("-f")){
            this.file = args[1];
            this.mode = new String("read file");

            this.readFromFile(args);
            
        }else{
            System.out.println("Invalid command line arguments.");
            System.exit(0); 
        }
    }

    /**
     * Reads the command line arguments and initializes the values accordingly.
     *
     * @param args the command line arguments
     */
    private void readFromArgs(String[] args){
        this.file = "";
        this.mode = new String("generate");
        this.nodes = Integer.parseInt(args[1]);
        this.maxEdgeWeight = Integer.parseInt(args[2]); //Maximum edge weight
        this.nestNode = Integer.parseInt(args[3]);
        this.alfa = Double.parseDouble(args[4]);
        this.beta = Double.parseDouble(args[5]);
        this.delta = Double.parseDouble(args[6]);
        this.eta =Double.parseDouble(args[7]);
        this.rho = Double.parseDouble(args[8]);
        this.pheromoneLevel = Double.parseDouble(args[9]);
        this.colonySize = Integer.parseInt(args[10]);
        this.finalInstant = Double.parseDouble(args[11]);
    }

     /**
     * Reads the command line arguments and initializes the values accordingly.
     *
     * @param args the command line arguments
     */
    private void readFromFile(String[] args){
        try {
            String filePath = args[1];

            // Check if the file path is a relative path
            if (filePath.startsWith("./") || filePath.startsWith(".\\")) {
                // Prepend it with the current directory path
                String currentDir = System.getProperty("user.dir");
                filePath = currentDir + File.separator + filePath.substring(2);
            }

            File file = new File(filePath);


            Scanner scanner = new Scanner(file);

            // Read the variables
            this.nodes = scanner.nextInt();
            this.maxEdgeWeight = 0;
            this.nestNode = scanner.nextInt();
            this.alfa = scanner.nextDouble();
            this.beta = scanner.nextDouble();
            this.delta = scanner.nextDouble();
            this.eta = scanner.nextDouble();
            this.rho = scanner.nextDouble();
            this.pheromoneLevel = scanner.nextDouble();
            this.colonySize = scanner.nextInt();
            this.finalInstant = scanner.nextDouble();
            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
    }

    @Override
    public boolean fileMode(){
        return this.mode.equals("file");
    }

    @Override
    public boolean readMode(){
        return this.mode.equals("read");
    }
    
}