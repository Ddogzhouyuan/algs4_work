package CH1;

public class Solution1_1_9 {
	public static String toBinaryString(int N) {
		String s = "";
	    for (int n = N; n > 0; n /= 2) {
	    	s = (n % 2) + s;
	    }
	    return s;
	}
	public static void main(String[] args) {
		int n = 100;
		String result = toBinaryString(n);
		System.out.println(result);
	}
}
