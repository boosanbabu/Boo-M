package dsa.leetcode.medium.graph;
/*
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathMatrix {
	static final int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int[][] memoize = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int count = recurse(i, j, matrix, memoize);
				max = Math.max(max, count);
			}
		}
		return max;
	}

	private int recurse(int i, int j, int[][] orig, int[][] memoize) {
		if (memoize[i][j] > 0)
			return memoize[i][j];
		int max = 0;
		for (int[] d : dir) {
			int count = 0;
			int newI = i + d[0], newJ = j + d[1];
			if (isOutOfBound(orig, newI, newJ) || orig[newI][newJ] <= orig[i][j])
				continue;
			count = recurse(newI, newJ, orig, memoize) + 1;
			max = Math.max(max, count);
		}
		memoize[i][j] = max;
		return max;
	}

	public boolean isOutOfBound(int[][] arr, int i, int j) {
		if (i < 0 || j < 0 || i > arr.length - 1 || j > arr[0].length - 1)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		LongestIncreasingPathMatrix l = new LongestIncreasingPathMatrix();
		l.longestIncreasingPath(matrix);

	}

}
