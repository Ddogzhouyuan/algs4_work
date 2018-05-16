package CH1;

import java.util.Arrays;

public class Solution1_1_15 {
	public static int[] histogram(int[] a, int M) {
		int[] result = new int[M];
		for (int i = 0; i < M; i++) {
			int freq = 0;
			for (int j : a) {
				if (j == i) freq++;
			}
			result[i] = freq;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {0, 0, 1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 6, 7, 7, 7, 7, 8};
		int[] res = histogram(a, 9);
		System.out.println(Arrays.toString(res));
	}
}
