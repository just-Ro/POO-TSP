package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The GraphReaderStrategy class implements the IGraphCreationStrategy interface
 * and provides a strategy for filling a weighted graph by reading the graph data from a file.
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class GraphReaderStrategy implements IGraphCreationStrategy{

    @Override
    public void fill(WeightedGraph graph, int nodes, int maxWeight, String file) {
        try{
            File f = new File(file);
            Scanner scanner = new Scanner(f);
            //Ignore First Line
            scanner.nextLine();
            
            for (int i = 1; i <= nodes; i++) {
                for (int j = 1; j <= nodes; j++) {
                    int weight = scanner.nextInt();
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
