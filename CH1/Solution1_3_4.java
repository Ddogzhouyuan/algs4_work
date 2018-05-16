package CH1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Solution1_3_4 {
	public static void main(String[] args) {
		Stack<String> s1 = new Stack<String>();
		boolean res = true;
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("{") || item.equals("[") || item.equals("(")) s1.push(item);
			else if ((!s1.isEmpty()) && item.equals("}")) {
				String temp = s1.pop();
				if (!temp.equals("{")) res = false;
			} else if ((!s1.isEmpty()) && item.equals("]")) {
				String temp = s1.pop();
				if (!temp.equals("[")) res = false;
			} else if ((!s1.isEmpty()) && item.equals(")")) {
				String temp = s1.pop();
				if (!temp.equals("(")) res = false;
			} else res = false;
		}
		StdOut.print("result: " + res);
	}
}
