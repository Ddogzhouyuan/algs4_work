package CH1;

import edu.princeton.cs.algs4.StdIn;

public class Solution1_3_6 {
	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			q.enqueue(item);
		}
		
		Stack<String> stack = new Stack<String>();
		while (!q.isEmpty()) {
			stack.push(q.dequeue());
		}
		while (!stack.isEmpty()) {
			q.enqueue(stack.pop());
		}
	}
}
