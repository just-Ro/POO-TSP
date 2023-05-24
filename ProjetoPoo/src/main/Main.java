package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Cristina!");
        
        if(args.length < 2){
            System.out.println("Not enough command line arguments.");
            System.exit(0);
        }

        Args params = new Args(args);   // Parse command line arguments

        if(params.mode.equals("read")){
            // Read mode
            if (args.length < 12) {
                System.out.println("Please provide command-line arguments.");
                System.exit(0);
            }
            System.out.println("modo -r");

            int[][] matrix = new int[params.n][params.n];

            //Fill Graph with random values between 1 and a
            for (int i = 0; i < params.n; i++) {
                for (int j = 0; j < params.n; j++) {
                    //matrix[i][j] = random.nextInt(a) + 1;
                    matrix[i][j] = 0;
                }
            }

        }else if(params.mode.equals("file")){
            // File mode
            File file = new File(params.file);
            Scanner scanner = new Scanner(file);
            //Ignore First Line
            scanner.nextLine();
            // Read the matrix
            int[][] matrix = new int[params.n][params.n];
            for (int i = 0; i < params.n; i++) {
                for (int j = 0; j < params.n; j++) {
                    matrix[i][j] =scanner.nextInt();
                }
            }
            scanner.close();
            for (int i = 0; i < params.n; i++) {
                for (int j = 0; j < params.n; j++) {
                    System.out.println(matrix[i][j]);
                }}
            
        }


    }
}