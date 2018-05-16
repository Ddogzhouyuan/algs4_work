package CH1;

import java.util.Arrays;

public class Solution1_1_13 {
	public static void print_transpose(int[][] A) {
		int M = A.length;
		int N = A[0].length;
		int[][] B = new int[N][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				B[j][i] = A[i][j];
			}
		}
		System.out.println(Arrays.deepToString(B));
	}
	
	public static void main(String[] args) {
		int[][] A = new int[5][5];
		for (int i = 0; i < 25; i++) {
			int M = i / 5;
			int N = i % 5;
			A[M][N] = i;
		}
		System.out.println(Arrays.deepToString(A));
		print_transpose(A);
	}
}
