package assignment3;

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
	private ArrayList<LineSegment> lineSgmts;
	private Point[] pointSet;
	public FastCollinearPoints(Point[] points) {
		// finds all line segments containing 4 or more points
		if (points == null) throw new NullPointerException();
		
		int len = points.length;
		
		pointSet = Arrays.copyOf(points, len);
		lineSgmts = new ArrayList<LineSegment> ();
		Merge.sort(pointSet);
		
		for (int i = 0; i < len - 1; i++) {
			double[] slopesBefore = new double[i];
			Point[] pointAfter = new Point[len - i - 1];
			
			for (int j = 0; j < i; ++j) {
				slopesBefore[j] = pointSet[i].slopeTo(pointSet[j]);
			}
			
			for (int j = 0; j < len - i - 1; ++j) {
				pointAfter[j] = pointSet[i + j + 1];
			}
			
			Arrays.sort(slopesBefore);
			Arrays.sort(pointAfter, pointSet[i].slopeOrder());
			addNewSgmts(slopesBefore, pointSet[i], pointAfter);
		}
	}
	
	private void addNewSgmts(double[] slopeBefore, Point srtPoints, Point[] pointAfter) {
		int cnt = 1;
		int lenOfSub = pointAfter.length;
		double slope = Double.NEGATIVE_INFINITY;
		double lastSlope = Double.NEGATIVE_INFINITY;
		
		for (int j = 0; j < lenOfSub; ++j) {
			checkForDuplicates(srtPoints, pointAfter[j]);
			slope = srtPoints.slopeTo(pointAfter[j]);
			if (lastSlope != slope) {
				if (cnt >= 3 && !isSubSgmt(slopeBefore, lastSlope)) {
					lineSgmts.add(new LineSegment(srtPoints, pointAfter[j - 1]));
				}
				cnt = 1;
			}
			else cnt++;
			lastSlope = slope;
		}
		
		if (cnt >= 3 && !isSubSgmt(slopeBefore, lastSlope)) {
			lineSgmts.add(new LineSegment(srtPoints, pointAfter[lenOfSub - 1]));
		}
	}
	
	private boolean isSubSgmt(double[] slopeBefore, double slope) {
		int lo = 0;
		int hi = slopeBefore.length - 1;
		
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (slope < slopeBefore[mid]) hi = mid - 1;
			else if (slope > slopeBefore[mid]) lo = mid + 1;
			else return true;
		}
		return false;
	}
	
	public int numberOfSegments() {
		// the number of line segments
		return lineSgmts.size();
	}
	
	public LineSegment[] segments() {
		// the line segments
		return lineSgmts.toArray(new LineSegment[numberOfSegments()]);
	}
	
	private void checkForDuplicates(Point p, Point q) {
		if (p == null | q == null) throw new NullPointerException();
		if (p.compareTo(q) == 0) throw new IllegalArgumentException();
	}
	
	public static void main(String[] args) {
		In in  = new In(args[0]);
		int n = in.readInt();
		Point[] points = new Point[n];
		
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
		}
		
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		
		for (Point p: points) {
			p.draw();
		}
		
		StdDraw.show();
		FastCollinearPoints collinear = new FastCollinearPoints(points);
		
		for (LineSegment segment: collinear.segments()) {
			StdOut.println(segment);
			segment.draw();
		}
		StdDraw.show();
		
	}
}
