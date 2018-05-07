package assignment2;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class Deque<Item> implements Iterable<Item> {
	private int N;
	private Node first, last;
	
	private class Node {
		Item item;
		Node next;
		Node previous;
	}
	
	public Deque() {// construct an empty deque
		first = last = null;
		N = 0;
	}
	
	public boolean isEmpty() { // is the deque empty?
		return N == 0;
	}
	
	public int size() { // return the number of items on the deque
		return N;
	}
	
	public void addFirst(Item item) { // add the item to the front
		if (item == null) throw new NullPointerException();
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.previous = null;
		if (isEmpty()) {
			last = first;
			first.next = null;
		} else {
			first.next = oldfirst;
			oldfirst.previous = first;
		}
		N++;
	}
	
	public void addLast(Item item) { // add the item to the end
		if (item == null) throw new NullPointerException();
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.previous = null;
		if (isEmpty()) {
			first = last;
			last.previous = null;
		} else {
			last.previous = oldlast;
			oldlast.next = last;
		}
		N++;
	}
	
	public Item removeFirst() { // remove and return the item from the front
		if (isEmpty()) throw new NoSuchElementException();
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) {
			last = first = null;
		} else {
			first.previous = null;
		}
		return item;
	}
	
	public Item removeLast() { // remove and return the item from the end
		if (isEmpty()) throw new NoSuchElementException();
		Item item = last.item;
		last = last.previous;
		N--;
		if (isEmpty()) {
			first = last = null;
		} else {
			last.next = null;
		}
		return item;
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current;
		
		public ListIterator(Node first) {
			current = first;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	
	public Iterator<Item> iterator() { // return an iterator over items in order from front to end
		return new ListIterator(first);
	}
	
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.removeLast();
        System.out.println(deque.isEmpty());
        for (int i = 0; i < 10; i++) {
            deque.addFirst(i);
            deque.addLast(i * 10);
        }
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        while (!deque.isEmpty()) {
            System.out.println(deque.removeFirst());
        }
        deque.addFirst(1);
        System.out.println(deque.removeFirst());
        deque.addFirst(2);
        System.out.println(deque.removeFirst());
        deque.addLast(0);
        deque.removeFirst();
        deque.addLast(3);
        deque.addLast(4);
        deque.removeFirst();
        deque.removeLast();
        deque.addFirst(8);
	}
}
