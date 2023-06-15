package ant_colony_optimization;

import java.util.ArrayList;

public class Path extends ArrayList<Integer>{

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Path: ");
        for (int i = 0; i < size(); i++) {
            sb.append(get(i));
            if (i < size() - 1) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }

    /**Constructs an ArrayList of type Integer initialized with element
     * @param element element initialized on the path
     */
    public Path(int element){
        super();
        add(0,element);
    }

    /**Removes all elements starting from the end and stopping at element.
     * The element is removed.
     * If the element is not on the path, the entire path is removed.
     * @param element stopping element
     */
    public void clearUntil(int index){
        super.removeRange(index, size());
    }

    // not in use
    public int clearPath(int from, int to){
        for(int j=from; j<to; j++){
            remove(from);
        }
        return size()-1;
    }

    /* public List<Integer> getPath() {
        return path;
    } */

}
