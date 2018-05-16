package CH1;

public class Solution1_1_3 {
	public static boolean equal(int x, int y, int z) {
		if (x == y && y == z) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		boolean result = equal(a, b, c);
		System.out.println(result);
		
	}
}
