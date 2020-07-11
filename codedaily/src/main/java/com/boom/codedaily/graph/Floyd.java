package com.boom.codedaily.graph;
import java.util.Arrays;

public class Floyd {
	public static int I = Integer.MAX_VALUE / 2;

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int d[][] = new int[n][n];
		int i = 0;
		for (int a[] : d) {
			Arrays.fill(a, I);
			d[i][i] = 0;
			i++;

		}

		for (int[] e : edges) {
			d[e[0]][e[1]] = e[2];
			d[e[1]][e[0]] = e[2];
		}
		floyd(d);

		int minCities = Integer.MAX_VALUE;
		int res = 0;
		for (i = 0; i < d.length; i++) {
			int c = 0;
			for (int j = 0; j < d.length; j++) {
				if (d[i][j] <= distanceThreshold) {
					c++;
				}
			}
			if (c <= minCities) {
				res = i;
				minCities = c;
			}
		}
		return res;
	}

	class Solution {
		public int removeCoveredIntervals(int[][] intervals) {
			Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
			int max = -1, res = 0;
			for (int i = 0, j = 0; i < intervals.length; res++, i = j) {
				for (; j < intervals.length && intervals[j][0] <= intervals[i][0]; j++) {
					max = Math.max(max, intervals[j][1]);
				}
				for (; j < intervals.length && intervals[j][1] <= max; j++)
					;
			}
			return res;
		}
	}

	public static void floyd(int d[][]) {
		for (int k = 0; k < d.length; k++) {
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d.length; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 0, 1, 3, 2 }, { 1, 0, 1, 3 }, { 3, 1, 0, 1 }, { 2, 3, 1, 0 } };
		int[][] d = a.clone();
		floyd(d);
		Floyd floyd = new Floyd();
		int[][] edges = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int distanceThreshold = 2;
		int r = floyd.findTheCity(5, edges, distanceThreshold);
		System.out.println(r);
	}

}
