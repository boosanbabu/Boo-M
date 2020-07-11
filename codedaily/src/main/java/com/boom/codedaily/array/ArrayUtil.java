package com.boom.codedaily.array;

public class ArrayUtil {

	public static void reverse(int arr[], int start, int end) {
		int n = end - start + 1;
		int i = 0;
		while (i < n / 2) {
			swap(arr, start + i, end - i);
			i++;
		}
	}

	public static void reverse(int arr[]) {
		reverse(arr, 0, arr.length - 1);
	}

	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	public static boolean equals(int a[], int b[]) {
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;

		return true;
	}

	public static void checkEquals(int a[], int b[]) {
		System.out.println(equals(a, b) ? "Passed" : "Failed");
	}

	public static void print(int[][] board) {
		for (int r[] : board) {
			for (int i : r)
				System.out.print(i + "\t");
			System.out.println();
		}
	}

	class Solution {
		private static final int ZERO_TO_ONE = 2;
		private static final int ONE_TO_ZERO = 3;

		public void gameOfLife(int[][] board) {
			if (board.length == 0)
				return;
			for (int i = 0; i < board.length; i++)
				for (int j = 0; j < board[0].length; j++) {
					int live = getNeighbours(board, i, j);
					transform(board, i, j, live);
				}
			retransform(board);
		}

		private void retransform(int[][] board) {
			for (int i = 0; i < board.length; i++)
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 3)
						board[i][j] = 0;
					else if (board[i][j] == 2)
						board[i][j] = 1;
				}
		}

		public void transform(int[][] board, int i, int j, int live) {
			if (board[i][j] % 2 == 1) {
				if (live < 2 || live > 3) {
					board[i][j] = ONE_TO_ZERO;
				}
			} else if (live == 3)
				board[i][j] = ZERO_TO_ONE;
		}

		public int getNeighbours(int[][] board, int i, int j) {
			int[] dir = { -1, 0, 1 };
			int n = 0, d = 0;
			for (int di : dir) {
				int ni = i + di;
				if (ni >= 0 && ni < board.length) {
					for (int dj : dir) {
						int nj = j + dj;
						if (nj >= 0 && nj < board[0].length && !(ni == i && nj == j) && board[ni][nj] % 2 != 0)
							n++;
					}
				}
			}
			return n;
		}
	}

}
