package CH1;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings<Item> implements Iterable<Item> {
	private Item[] a;
	private int N;
	private int first;
	private int last;
	
	public ResizingArrayQueueOfStrings() {
		a = (Item[]) new Object[2];
		N = 0;
		first = 0;
		last = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void resize(int max) {
		assert max >= N;
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[(first + i) % a.length];
		}
		a = temp;
		first = 0;
		last = N;
	}
	
	public void enqueue(Item item) {
		if (N == a.length) resize(2 * a.length);
		a[last++] = item;
		if (last == a.length) last = 0;
		N++;
	}
	
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException();
		Item item = a[first];
		N--;
		first++;
		if (first == a.length) first = 0;
		if (N > 0 && N == a.length / 4) resize(a.length / 2);
		return item;
	}
	
	public Item peek() {
		return a[first];
	}
	
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<Item> {
		private int i = 0;
		
		public boolean hasNext() {
			return i < N;
		}
		
		public void remove() {
			
		}
		
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = a[(i + first) % a.length];
			i++;
			return item;
		}
	}
	
	public static void main(String[] args) {
		ResizingArrayQueueOfStrings<String> queue = new ResizingArrayQueueOfStrings<String>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) queue.enqueue(item);
			else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
		}
		StdOut.println("( " + queue.size() + " left on queue )");
	}
}
