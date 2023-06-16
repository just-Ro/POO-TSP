package ant_colony_optimization;

import java.lang.reflect.Array;
import java.util.ArrayList;

import graph.WeightedGraph;

/**
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class Path extends ArrayList<Integer>{
    WeightedGraph graph;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < size(); i++) {
            sb.append(get(i));
            if (i < size() - 1) {
                sb.append(","); //{1,5,4,2,3}:14
            }
        }
        sb.append("}:");
        sb.append(pathWeight());
        return sb.toString();
    }

    /**Constructs an ArrayList of type Integer initialized with element
     * @param element element initialized on the path
     */
    public Path(int element, WeightedGraph graph){
        super();
        add(0,element);
        this.graph = graph;
    }

    public Path(WeightedGraph graph){
        super();
        this.graph = graph;
    }
    
    public Path copy() {
        Path copy = new Path(this.graph);
        copy.addAll(this);
        return copy;
    }

    /**Removes all elements starting from the end and stopping at element.
     * The element is removed.
     * If the element is not on the path, the entire path is removed.
     * @param element stopping element
     */
    public void clearUntil(int index){
        //System.out.print("before: ");
        //System.out.println(this);
        super.removeRange(index, size()-1);
        remove(size()-1);
        //System.out.print("after: ");
        //System.out.println(this);
    }

    public int pathWeight(){
        int w=0;

        for(int i=0; i<size()-1; i++){
            w += graph.getEdge(get(i),get(i+1));
        }

        return w;
    }

    // not in use
    public int clearPath(int from, int to){
        for(int j=from; j<to; j++){
            remove(from);
        }
        return size()-1;
    }

    public Path invertPath(Path path){
        int aux;
        for(int i=0; i<(path.size()-path.size()%2)/2; i++){
            aux = i;
            i = path.get(path.size()-i);
            path.set(path.size()-i,path.get(i));
            path.set(i, aux);
        }

        return path;
    }


    public boolean equals(Path path){
        if(size()!=path.size())
            return false;

        boolean exact = true, reversed = true;
        for(int i=0; i<size(); i++){
            if(get(i)!=path.get(i)) 
                exact = false;
            if(get(i)!=path.get(size()-i-1))
                reversed = false;
        }
        if(!exact && !reversed)
            return false;
        
        return true;
    }

}


