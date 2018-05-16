package CH1;

public class Solution1_1_5 {
	public static boolean judge(double x, double y) {
		if ((x<=1 && x >= 0) && (y <= 1 && y >= 0)) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		boolean result = judge(a, b);
		System.out.println(result);
	}
}
