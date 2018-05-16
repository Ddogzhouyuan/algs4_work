package CH1;

import java.util.Arrays;

public class Solution1_1_12 {
	public static void main(String[] args) {
		int[] a = new int[10];
	    for (int i = 0; i < 10; i++)
	       a[i] = 9 - i;
	    System.out.println(Arrays.toString(a));
	    for (int i = 0; i < 10; i++)
	       a[i] = a[a[i]];
	    System.out.println(Arrays.toString(a));
	    for (int i = 0; i < 10; i++)
	       System.out.println(i);
	}
}
