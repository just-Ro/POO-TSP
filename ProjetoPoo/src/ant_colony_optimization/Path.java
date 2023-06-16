package ant_colony_optimization;

import java.util.ArrayList;

import graph.WeightedGraph;

/**
 * The Path class represents a path in a weighted graph.
 * It extends ArrayList<Integer> and provides additional methods
 * to manipulate and calculate properties of the path.
 * 
 * It also overrides the toString() method to provide a custom string representation of the path.
 *
 * @author João Mateus 
 * @author Tiago Mira
 * @author Rodrigo Francisco
 */
public class Path extends ArrayList<Integer> implements IPath{
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

    /**
     * Constructs a Path object with the specified initial element and associated weighted graph.
     * 
     * @param element the initial element of the path
     * @param graph the associated weighted graph
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
    
    @Override
    public Path copy() {
        Path copy = new Path(this.graph);
        copy.addAll(this);
        return copy;
    }

    @Override
    public void clearUntil(int index){
        //System.out.print("before: ");
        //System.out.println(this);
        super.removeRange(index, size()-1);
        remove(size()-1);
        //System.out.print("after: ");
        //System.out.println(this);
    }

    @Override
    public int pathWeight(){
        int w=0;

        for(int i=0; i<size()-1; i++){
            w += graph.getEdge(get(i),get(i+1));
        }

        return w;
    }

    @Override
    public int clearPath(int from, int to){
        for(int j=from; j<to; j++){
            remove(from);
        }
        return size()-1;
    }

    @Override
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

    @Override
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

    @Override
    public void addElement(int element) {
        add(element);
    }

    @Override
    public int getElement(int index){
        return get(index);
    }

}


