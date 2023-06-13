package graph;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class APath<N,E> {
    Deque<N> nodes;
    Deque<E> edges;

    public APath(){
        this.nodes = new ArrayDeque<>(0);
        this.edges = new ArrayDeque<>(0);
    }

    public void addNode(N node, E edge){
        nodes.addFirst(node);
        if(!nodes.isEmpty()){
            edges.addFirst(edge);
        }
    }

    public void popNode(){
        nodes.removeFirst();
        if(!nodes.isEmpty()){
            edges.removeFirst();
        }
    }

    public N getLastNode(){
        return nodes.getFirst();
    }

    public E getLastEdge(){
        if(nodes.size() == 1){
            return null;
        }
        return edges.getFirst();
    }
}
