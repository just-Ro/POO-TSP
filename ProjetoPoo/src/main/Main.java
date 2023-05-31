package main;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Program started!!!\\-;-/   ()   ()   \\-;-/");
        Args params = new Args(args);   // Parse command line arguments
        
        if(params.readMode()){
            // Read mode
            System.out.println("modo -r");
            Graph graph = new Graph(params.nodes, params.maxEdgeWeight);
            System.out.print(graph);

        }else if(params.fileMode()){
            // File mode
            Graph graph = new Graph(params.nodes);
            graph.readGraph(params.file);
        
        }
    }
}
