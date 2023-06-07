package graph;

import java.util.Iterator;

// Não sei bem como usar, pode ser útil
public class EdgeIterator<T> implements Iterator<T> {
    private T[] elements;
    private int currentIndex;

    public EdgeIterator(T[] elements) {
        this.elements = elements;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < elements.length;
    }

    @Override
    public T next() {
        T element = elements[currentIndex];
        currentIndex++;
        return element;
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
}
