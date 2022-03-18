package deque;

import java.util.Iterator;

public abstract class AbstractDeque<T> implements Deque<T>, Iterable<T> {

    /** Returns whether or not the parameter o is equal to the Deque.
     * o is considered equal if it is a Deque and if it contains the same contents
     * (as goverened by the generic T’s equals method) in the same order.
     * (ADDED 2/12: You’ll need to use the instance of keywords for this.
     * Read here for more information) */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Iterable)) {
            return false;
        }
        Iterator<T> oSeer = ((Iterable<T>) o).iterator();
        Iterator<T> thisSeer = this.iterator();
        while (oSeer.hasNext() && thisSeer.hasNext()) {
            if (!oSeer.next().equals(thisSeer.next())) {
                return false;
            }
        }
        return !oSeer.hasNext() && !thisSeer.hasNext();
    }
}
