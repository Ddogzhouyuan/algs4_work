package CH1;

import edu.princeton.cs.algs4.StdOut;

public class Solution1_1_7 {
	public static void func1() {
		double t = 9.0;
		while (Math.abs(t - 9.0 / t) > .001) {
			t = (9.0 / t + t) / 2.0;
		}
		StdOut.printf("%.5f\n",t);
	}
	
	public static void func2() {
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
		}
		StdOut.println(sum);
	}
	
	public static void func3() {
		int sum2 = 0;
		for (int i = 0; i < 1000; i = i * 2) {
			for (int j = 0; j < i; j++) {
				sum2++;
			}
		}
		StdOut.println(sum2);
	}
	
	public static void main(String[] args) {
		func1();
		func3();
		/*func3();*/
	}
}
