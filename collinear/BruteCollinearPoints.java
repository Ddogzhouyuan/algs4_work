package assignment3;

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
	private LineSegment[] segments;
	
	private void checkDuplicateEntries(Point[] points) {
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i; j < points.length; j++) {
				if (points[i].compareTo(points[j]) == 0) {
					throw new IllegalArgumentException();
				}
			}
		}
	}
	
	public BruteCollinearPoints(Point[] points) {
		// finds all line segments containing 4 points
		if (points == null) throw new NullPointerException();
		checkDuplicateEntries(points);
		int len = points.length;
		
		Point[] pointSet = Arrays.copyOf(points, len);
		Arrays.sort(pointSet);
		ArrayList<LineSegment> lineSgmts = new ArrayList<LineSegment>();
		
		for (int p = 0; p < len - 3; p++) {
			for (int q = p + 1; q < len - 2; q++) {
				for (int r = q + 1; r < len - 1; r++) {
					for (int s = r + 1; s < len; s++) {
						if (pointSet[p].slopeTo(pointSet[q]) == pointSet[p].slopeTo(pointSet[r]) && 
								pointSet[p].slopeTo(pointSet[q]) == pointSet[p].slopeTo(pointSet[s])) {
							lineSgmts.add(new LineSegment(pointSet[p], pointSet[s]));
						}
					}
				}
			}
		}
		segments = lineSgmts.toArray(new LineSegment[lineSgmts.size()]);
	}
	
	public int numberOfSegments() {
		// the number of line segments
		return segments.length;
	}
	
	public LineSegment[] segments() {
		// the line segments
		return Arrays.copyOf(segments, segments.length);
	}
	
	public static void main(String[] args)
    {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) 
        {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) { p.draw(); }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) 
        {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
