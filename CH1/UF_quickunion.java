package CH1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF_quickunion {
	private int[] id;
	private int count;
	
	public UF_quickunion(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q) {
		int qRoot = find(q);
		int pRoot = find(p);
		
		if (qRoot == pRoot) return ;
		
		id[pRoot] = qRoot;
		count--;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF_quickunion uf = new UF_quickunion(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + " components");
	}
}
