package ant_colony_optimization;

import java.util.ArrayList;
import java.util.List;

public class Path  {
    private List<Integer> path;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Path: ");
        for (int i = 0; i < path.size(); i++) {
            sb.append(get(i));
            if (i < path.size() - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

    public Path(int n){
        this.path = new ArrayList<Integer>();
        add(0,n);
    }

    public void add(int index, int value){
        path.add(index, value);
    }

    public int get(int n){
        return path.get(n);
    }

    public void remove(int n){
        path.remove(n);
    }

    public boolean contains(int n){
        if(path.contains(n))
            return true;
        return false;
    }

    public int clearPath(int from, int to){
        for(int j=from; j<to; j++){
            path.remove(from);
        }
        return path.size()-1;
    }

    public List<Integer> getPath() {
        return path;
    }

}
