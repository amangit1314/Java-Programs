package stack_and_queue;
import java.util.*;

/*
 * Implement Stack from Scratch Array Implementation
 */
public class Stack_Queue_Problem_01_i<Item> implements Iterable<Item> {

    @SuppressWarnings("unchecked")
    private Item[] a = (Item[]) new Object[1]; // Stack Items
    private int N = 0; // number of items

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        @SuppressWarnings("unchecked")
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;

    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        public int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

        public void remove() {

        }
    }

    public static void main(String[] args) {

    }
}
