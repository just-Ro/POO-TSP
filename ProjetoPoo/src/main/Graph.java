package main;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Graph {
    int[][] matrix;
    int n;
    public Graph(int nodes, int maxEdgeWeight){
        n = nodes;
        
        this.matrix = new int[n][n];
        //Fill Graph with random values between 1 and a
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //matrix[i][j] = random.nextInt(a) + 1;
                matrix[i][j] = 0;
            }
        }
    }

    public Graph(int nodes){
        n = nodes;

    }

    public void readGraph(String file){
        try{
            File f = new File(file);
            Scanner scanner = new Scanner(f);
            //Ignore First Line
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] =scanner.nextInt();
                }
            }

            scanner.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
    }

}
