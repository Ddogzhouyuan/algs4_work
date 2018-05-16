package CH1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
	public static void main(String[] args) {
		Stack<Integer> vals = new Stack<Integer>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("+")) {
				vals.push(vals.pop() + vals.pop());
			} else if (item.equals("-")) {
				vals.push(vals.pop() - vals.pop());
			} else if (item.equals("*")) {
				vals.push(vals.pop() * vals.pop());
			} else vals.push(Integer.parseInt(item));
		}
		StdOut.print(vals.pop());
	}
}
