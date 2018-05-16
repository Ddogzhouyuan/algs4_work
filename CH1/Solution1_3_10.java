package CH1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Solution1_3_10 {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		String res = "";
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("(") || item.equals("+") || item.equals("-") || 
					item.equals("*") || item.equals("/")) ops.push(item);
			else if (item.equals(")")) {
				String ops_temp = "";
				while (!ops_temp.equals("(")) {
					ops_temp = ops.pop();
					if (ops_temp.equals("(")) break;
					res = res + ops_temp + " ";
				}
			} else res = res + item + " ";
		}
		while (!ops.isEmpty()) {
			String ops_temp = ops.pop();
			if (ops_temp.equals("(")) break;
			res = res + ops_temp + " ";
			
		}
		StdOut.print(res);
	}
}
