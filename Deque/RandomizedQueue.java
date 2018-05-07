package assignment2;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] q;
	private int N = 0;
	
	public RandomizedQueue() {
		// construct an empty randomized queue
		q = (Item[]) new Object[2];
	}
	
	public boolean isEmpty() {
		// is the randomized queue empty?
		return N == 0;
	}
	
	public int size() {
		// return the number of items on the randomized queue
		return N;
	}
	
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = q[i];
		}
		q = temp;
	}
	
	public void enqueue(Item item) {
		// add the item
		if (item == null) throw new NullPointerException();
		if (N == q.length) resize(2 * q.length);
		/*if (N == 0) {
			q[N++] = item;
			return;
		}
		int randomIndex = StdRandom.uniform(N);
		Item temp = q[randomIndex];
		q[randomIndex] = item;
		q[N++] = temp;*/
		q[N++] = item; 
	}
	
	public Item dequeue() {
		// remove and return a random item
		if (isEmpty()) throw new NoSuchElementException();
		int offset = StdRandom.uniform(N);
		Item item = q[offset];
		if (offset != N - 1) q[offset] = q[N - 1];
		q[N - 1] = null;
		N--;
		if (N > 0 && N <= q.length/4) resize(q.length / 2);
		return item;
	}
	
	public Item sample()  {
		// return a random item (but do not remove it)
		if (isEmpty()) throw new NoSuchElementException();
		int offset = StdRandom.uniform(N);
		return q[offset];
	}
	
	private class ArrayIterator implements Iterator<Item>{
		private Item[] copyArray = (Item[]) new Object[q.length];
		private int copyN = N;
		
		public ArrayIterator() {
			for (int i = 0; i < q.length; i++) {
				copyArray[i] = q[i];
			}
		}
		
		public boolean hasNext() {
			return copyN != 0;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			int offset = StdRandom.uniform(copyN);
			Item item = copyArray[offset];
			if (offset != copyN - 1) {
				copyArray[offset] = copyArray[copyN - 1];
			}
			copyArray[copyN - 1] = null;
			copyN--;
			return item;
		}
	}
	
	public Iterator<Item> iterator() {
		// return an independent iterator over items in random order
		return new ArrayIterator();
	}
	
	public static void main(String[] args) {
		// unit testing (optional)
		RandomizedQueue<Integer> queue = new RandomizedQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		System.out.println(queue.size());
		for (Integer i : queue) {
			System.out.println(i);
		}
		System.out.println("sample:" + queue.sample());
		System.out.println("dequeue");
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
		System.out.println(queue.size());
	}
}
