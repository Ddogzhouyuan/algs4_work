package CH1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch2 {
	public static int rank(int key, int[] a, int lo, int hi) {
		if (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				/*int[] temp = Arrays.copyOfRange(a, lo, mid - 1);*/
				return rank(key, a, lo, mid - 1);
			} else if (key > a[mid]) {
				/*int[] temp = Arrays.copyOfRange(a, mid + 1, hi);*/
				return rank(key, a, mid + 1, hi);
			} else return mid;
		} else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		/*int[] whitelist = {1, 3, 4, 5, 7, 9};
		int key = 5;
		int res = rank(key, whitelist, 0, whitelist.length - 1);
		System.out.println(res);*/
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (rank(key, whitelist, 0, whitelist.length) < 0) StdOut.println(key);
		}
	}
}
