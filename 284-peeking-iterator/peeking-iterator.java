import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;
    private boolean hasPeeked;

    public PeekingIterator(Iterator<Integer> iterator) {
        // Initialize any member here.
        this.iterator = iterator;
        this.hasPeeked = false;
        
        // Pre-fetch the first element if available
        if (iterator.hasNext()) {
            this.nextElement = iterator.next();
            this.hasPeeked = true;
        }
    }
    
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            throw new java.util.NoSuchElementException();
        }
        return nextElement;
    }
    
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasPeeked) {
            return iterator.next();
        }
        
        Integer result = nextElement;
        hasPeeked = false;
        nextElement = null;
        
        // Pre-fetch the next element if available
        if (iterator.hasNext()) {
            nextElement = iterator.next();
            hasPeeked = true;
        }
        
        return result;
    }
    
    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }
}