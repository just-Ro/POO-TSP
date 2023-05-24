package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Args{
    public final int n, a, n1, alfa, beta, delta, eta, p, y, v, tau;
    public final String mode, file;

    public Args(String[] args){

        String option = args[0];
        if (option.equals("-r")) {
            this.file = "";
            this.mode = "read";
            this.n = Integer.parseInt(args[1]);
            this.a = Integer.parseInt(args[2]); //Maximum edge weight
            this.n1 = Integer.parseInt(args[3]);
            this.alfa = Integer.parseInt(args[4]);
            this.beta = Integer.parseInt(args[5]);
            this.delta = Integer.parseInt(args[6]);
            this.eta = Integer.parseInt(args[7]);
            this.p = Integer.parseInt(args[8]);
            this.y = Integer.parseInt(args[9]);
            this.v = Integer.parseInt(args[10]);
            this.tau = Integer.parseInt(args[11]);
            
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
                this.alfa = scanner.nextInt();
                this.beta = scanner.nextInt();
                this.delta = scanner.nextInt();
                this.eta = scanner.nextInt();
                this.p = scanner.nextInt();
                this.y = scanner.nextInt();
                this.v = scanner.nextInt();
                this.tau = scanner.nextInt();
    
                // Read the matrix
                int[][] matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
    
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