package CH1;

public class Solution1_1_20 {
	public static double compute(int N) {
		if (N <= 1) return 0.0;
		return Math.log(N) + compute(N - 1);
	}
	
	public static void main(String[] args) {
		int a = 20;
		double res = compute(a);
		System.out.println(res);
	}
}
