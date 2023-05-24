package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Cristina!");

        int n, a,n1,alfa,beta,delta,eta,p,y,v,tau;
        Random random = new Random();
        
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

            int[][] matrix = new int[n][n];

            //Fill Graph with random values between 1 and a
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = random.nextInt(a) + 1;
                }
            }

            //Remove one edge from the graph
            int rand1 , rand2;
            do{
                rand1 = random.nextInt(n);
                rand2 = random.nextInt(n);
            }while(rand1==rand2);

            matrix[rand1][rand2] = 0;

        }else if(params.mode.equals("file")){
            // File mode

        }else{
            // Unknown
            System.out.println("Unknown operation mode.");
            System.exit(0);
        }


        } else if (option.equals("-f")) {
            // Handle the -f option
            if (args.length < 2) {
                System.out.println("Please provide command-line arguments.");
                System.exit(0);
            }
            System.out.println("modo -f");
    
                // Read the matrix
                matrix = new int[n][n];
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

        } else {
            System.out.println("[Error] Unknown option: " + option);
            System.exit(0);
        }

    }
}