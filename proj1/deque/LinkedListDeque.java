package deque;

import java.util.Iterator;

public class LinkedListDeque<T> extends AbstractDeque<T> {

    public static class LinkedListNode<T> {
        // class variables of the LinkedListNode class
        public LinkedListNode<T> prev;
        public T item;
        public LinkedListNode<T> next;
        // constructor
        public LinkedListNode(LinkedListNode<T> p, T i, LinkedListNode<T> n) {
            prev = p;
            item = i;
            next = n;
        }
        // together to define the LinkedListNode class
    }

    // class variables of the LinkedListDeque class
    public LinkedListNode<T> sentinel;
    public int size = 0;
    // constructor
    public LinkedListDeque() {
        sentinel = new LinkedListNode<T>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    // together to define the LinkedListDeque class

    /** Adds an item of type T to the front of the deque. You can assume that item is never null. */
    @Override
    public void addFirst(T item) {
        LinkedListNode<T> node = new LinkedListNode<T>(sentinel, item, sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. You can assume that item is never null. */
    @Override
    public void addLast(T item) {
        LinkedListNode<T> node = new LinkedListNode<T>(sentinel.prev, item, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size += 1;
    }

//    /** Returns true if deque is empty, false otherwise. */
//    public boolean isEmpty() {
//        return sentinel.next == sentinel;
//    }

    /** Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line. */
    @Override
    public void printDeque() {
        LinkedListNode<T> curr = sentinel.next;
        for (int i = 0; i < size; i += 1) {
            System.out.print(curr.item);
            System.out.print(" ");
            curr = curr.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    @Override
    public T removeFirst() {
        LinkedListNode<T> first = sentinel.next;
        if (first != sentinel) {
            sentinel.next = first.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return first.item;
        } else {
            return null;
        }
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    @Override
    public T removeLast() {
        LinkedListNode<T> last = sentinel.prev;
        if (last != sentinel) {
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return last.item;
        } else {
            return null;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque! */
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        LinkedListNode<T> curr = sentinel;
        for (int i = 0; i <= index; i += 1) {
            curr = curr.next;
        }
        return curr.item;
    }

    /** The Deque objects we’ll make are iterable (i.e. Iterable<T>) so we must provide this method to return an iterator. */
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    public class LinkedListDequeIterator implements Iterator<T> {
        // private int wizPos;
        LinkedListNode<T> curr;
        private LinkedListDequeIterator() {
            // wizPos = 0;
            curr = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            // LinkedListNode<T> curr = sentinel.next;
            return curr != sentinel;
//            if (curr != sentinel) {
//                // wizPos += 1;
//                // curr = curr.next;
//                return true;
//            }
//            return false;
        }

        @Override
        public T next() {
            //LinkedListNode<T> curr = sentinel;
//            for (int i = 0; i <= wizPos; i += 1) {
//                curr = curr.next;
//            }
            T itemReturn = curr.item;
            curr = curr.next;
            return itemReturn;
        }
    }

//    /** Returns whether or not the parameter o is equal to the Deque.
//     * o is considered equal if it is a Deque and if it contains the same contents
//     * (as goverened by the generic T’s equals method) in the same order.
//     * (ADDED 2/12: You’ll need to use the instance of keywords for this.
//     * Read here for more information) */
//    public boolean equals(Object o) {
//        if (o == null) {
//            return false;
//        }
//        if (!(o instanceof Deque)) {
//            return false;
//        }
//        LinkedListDeque<T> oDeque = (LinkedListDeque<T>) o;
//        if (this.size != oDeque.size) {
//            return false;
//        }
//        Iterator<T> LLDequeSeer = this.iterator();
//        Iterator<T> oSeer = oDeque.iterator();
//        while (LLDequeSeer.hasNext()) {
//            if (!LLDequeSeer.next().equals(oSeer.next())) {
//                return false;
//            }
//        }
//        return true;
//    }
}
