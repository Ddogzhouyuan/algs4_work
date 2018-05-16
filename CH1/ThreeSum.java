package CH1;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						cnt += 1;
					}
				}
			}
		}
		return cnt;
	}
	
	public static int countFast(int[] a) {
		int N = a.length;
		int cnt = 0;
		Arrays.sort(a);
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (BinarySearch.rank(-(a[i] + a[j]), a) > j) cnt++; 
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.countFast(a);
		double time = timer.elapsedTime();
		StdOut.println(cnt + " Triples " + time);
	}
}
