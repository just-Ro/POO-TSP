package main;

import java.util.List;
import java.util.ArrayList;

public class Ant{
    protected List<Integer> path;
    protected int pathSize=0;

    public Ant(int n1){
        this.path = new ArrayList<Integer>();
        path.add(n1);
    }

    public void travel(int node){
        path.add(node, null);
        pathSize += 1;
    }

    public void chooseNextNode(Edge[][] matrix){
        
    }    
}