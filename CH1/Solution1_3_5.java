package CH1;

import edu.princeton.cs.algs4.StdOut;

public class Solution1_3_5 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(args[0]);
		while (N > 0) {
			stack.push(N % 2);
			N /= 2;
		}
	}

}
