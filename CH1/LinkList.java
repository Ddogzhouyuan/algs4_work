package CH1;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;


public class LinkList<Item> implements Iterable<Item>{
	private Node first;
	private int N;
	
	public class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void delete(int k) {
		if (k == 0) first = first.next;
		else {
			Node temp = first;
			for (int i = 1; i < k; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
		N--;
	}
	
	public boolean find(String s) {
		Node temp = first;
		while (temp.next != null) {
			if (temp.item.equals(s)) return true;
			temp = temp.next;
		}
		if (temp.item.equals(s)) return true;
		else return false;
	}
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			
		}
		
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		LinkList<String> a = new LinkList<String>();
		while (StdIn.isEmpty()) {
			String item = StdIn.readString();
			
		}
	}
}
