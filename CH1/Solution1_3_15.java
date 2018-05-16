package CH1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Solution1_3_15 {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		Queue<String> queue = new Queue<String>();
		StdOut.println(k);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			queue.enqueue(item);
			StdOut.println(queue.size());
		}
		while (queue.size() > k) {
			queue.dequeue();
		}
		StdOut.println("the kth element from last is: " + queue.dequeue());
	}
}
