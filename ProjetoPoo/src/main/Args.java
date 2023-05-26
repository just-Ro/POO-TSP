package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Args{
    public int n, a , n1;
    public double alfa, beta, delta, eta, p, y, v, tau;
    public final String mode, file;

    public Args(String[] args){

        String option = args[0];
        if (option.equals("-r")) {
            this.file = "";
            this.mode = "read";
            this.n = Integer.parseInt(args[1]);
            this.a = Integer.parseInt(args[2]); //Maximum edge weight
            this.n1 = Integer.parseInt(args[3]);
            this.alfa = Double.parseDouble(args[4]);
            this.beta = Double.parseDouble(args[5]);
            this.delta = Double.parseDouble(args[6]);
            this.eta =Double.parseDouble(args[7]);
            this.p = Double.parseDouble(args[8]);
            this.y = Double.parseDouble(args[9]);
            this.v = Double.parseDouble(args[10]);
            this.tau = Double.parseDouble(args[11]);
            
        }else if(option.equals("-f")){
            this.file = args[1];
            this.mode = "file";

            try {
                File file = new File(args[1]);
                Scanner scanner = new Scanner(file);
    
                // Read the variables
                this.n = scanner.nextInt();
                this.a = 0;
                this.n1 = scanner.nextInt();
                this.alfa = scanner.nextDouble();
                this.beta = scanner.nextDouble();
                this.delta = scanner.nextDouble();
                this.eta = scanner.nextDouble();
                this.p = scanner.nextDouble();
                this.y = scanner.nextDouble();
                this.v = scanner.nextDouble();
                this.tau = scanner.nextDouble();
                // Close the scanner
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
            
        }else{
            throw new IllegalArgumentException("Invalid input argument"); 
        }
    }
}