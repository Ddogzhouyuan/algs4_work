package CH1;

import java.util.Arrays;

public class Solution1_1_11 {
	public static char[][] tran_bool_matrix(boolean[][] A) {
		int n_row = A.length;
		int n_col = A[0].length;
		char[][] result = new char[n_row][n_col];
		for(int i = 0; i < n_row; i++) {
			for (int j = 0;j < n_col; j++) {
				if (A[i][j]) result[i][j] = '*';
				else result[i][j] = ' ';
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		boolean[][] B = new boolean[3][3];
		B[0][0] = true;
		B[1][1] = true;
		B[2][2] = true;
		char[][] result = tran_bool_matrix(B);
		System.out.println(Arrays.deepToString(result));
	}
}
