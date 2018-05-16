package CH1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Solution1_3_9 {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		String result = "";
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals(")")) {
				if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
					ops.push(item);
				} else vals.push(item);
			} else {
				String ops_temp = ops.pop();
				String val1 = vals.pop();
				String val2 = vals.pop();
				result = "(" + " " + val2 + " " + ops_temp + " " + val1 + " )";
				vals.push(result);
			}
		}
		StdOut.print(vals.pop());
	}
}
