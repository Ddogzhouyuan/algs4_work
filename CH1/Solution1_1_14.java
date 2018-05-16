package CH1;

public class Solution1_1_14 {
	public static int get_lg_int(int N) {
		int res = 0;
		int cur = 1;
		while (2 * cur <= N) {
			cur = 2 * cur;
			res++;
		}
		System.out.println(res);
		return res;
	}
	
	public static void main(String[] args) {
		int a = 10;
		int res = get_lg_int(a);
	}
}
