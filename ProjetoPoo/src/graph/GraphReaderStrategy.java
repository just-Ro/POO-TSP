package graph;

import java.io.*;
import java.util.*;

public class GraphReaderStrategy implements IGraphCreationStrategy{

    @Override
    public void fill(WeightGraph graph, Integer nodes, Integer maxWeight, String file) {
        try{
            File f = new File(file);
            Scanner scanner = new Scanner(f);
            //Ignore First Line
            scanner.nextLine();
            
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    Integer weight = scanner.nextInt();
                    if(weight > 0){
                        graph.addEdge(i, j, weight);
                    }
                }
            }

            scanner.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
    }
    
}
