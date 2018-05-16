package CH1;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> {
	private Node first;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Item peek() {
		return first.item;
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
	
	public void removeAfter(Node tar) {
		if (tar == null || tar.next == null) {}
		else tar.next = tar.next.next;
	}
	
	public void insertAfter(Node A, Node B) {
		if (A == null || B == null) {}
		else {
			B.next = A.next;
			A.next = B;
		}
	}
	
	public Node remove(String key) {
		Node temp = first;
		if (temp.item.equals(key)) temp = temp.next;
		while (temp.next != null) {
			if (temp.next.item.equals(key)) {
				temp.next = temp.next.next;
			}
		}
		return temp;
	}
	
	public Node reverse(Node x)
    {
       Node first = x;
       Node reverse = null;
       while (first != null) {
          Node second = first.next;
          first.next = reverse;
          reverse = first;
          first = second;
       }
       return reverse;
    }
	
	public Node reverse2(Node first)
    {
       if (first == null) return null;
       if (first.next == null) return first;
       Node second = first.next;
       Node rest = reverse(second);
       second.next = first;
       first.next = null;
       return rest;
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
	
	public static Stack<String> copy(Stack<String> stack_old) {
		Iterator<String> iter = stack_old.iterator();
		Stack<String> temp = new Stack<String>();
		while (iter.hasNext()) {
			temp.push(iter.next());
		}
		Iterator<String> iter2 = temp.iterator();
		Stack<String> res = new Stack<String>();
		while (iter2.hasNext()) {
			res.push(iter2.next());
		}
		return res;
	}
	
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) s.push(item);
			else if (!s.isEmpty()) StdOut.println(s.pop() + " ");
		}
		StdOut.println("( " + s.size() + " left on stack)");
		Iterator<String> s_iter = s.iterator();
		while(s_iter.hasNext()) {
			StdOut.print(s_iter.next() + " ");
		}
		StdOut.print("\n");
		Stack<String> s_copy = copy(s);
		Iterator<String> s_copy_iter = s_copy.iterator();
		while(s_copy_iter.hasNext()) {
			StdOut.print(s_copy_iter.next() + " ");
		}
		StdOut.print("\n");
		StdOut.println(s.size());
		s.delete(1);
		StdOut.println(s.size());
		Iterator<String> s_iter2 = s.iterator();
		while(s_iter2.hasNext()) {
			StdOut.print(s_iter2.next() + " ");
		}
		
		StdOut.println("\n" + s.find("q"));
//		s.remove("be");
		s.first = s.reverse(s.first);
		Iterator<String> s_iter3 = s.iterator();
		while(s_iter3.hasNext()) {
			StdOut.print(s_iter3.next() + " ");
		}
		StdOut.print("\n");
		
		s.first = s.reverse2(s.first);
		Iterator<String> s_iter4 = s.iterator();
		while(s_iter4.hasNext()) {
			StdOut.print(s_iter4.next() + " ");
		}
		StdOut.print("\n");
		
		StdOut.println("\n" + s.find("q"));
//		s.remove("be");
		s.first = s.remove("be");
		Iterator<String> s_iter5 = s.iterator();
		while(s_iter5.hasNext()) {
			StdOut.print(s_iter5.next() + " ");
		}
		StdOut.print("\n");
	}
}
