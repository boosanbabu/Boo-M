package com.boom.codedaily.array;

public class RotateArray {
	public void rotate(int[][] matrix) {
		for (int[] row : matrix) {
			reverse(row, 0, row.length - 1);
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				swap(matrix, i, j, matrix.length -1- i, matrix[0].length - 1 - j);
			}
		}
		System.out.println();

	}

	private void swap(int[][] matrix, int i, int j, int ni, int nj) {
		matrix[i][j] = matrix[i][j] ^ matrix[ni][nj];
		matrix[ni][nj] = matrix[i][j] ^ matrix[ni][nj];
		matrix[i][j] = matrix[i][j] ^ matrix[ni][nj];
	}

	public static void reverse(int arr[], int start, int end) {
		int n = end - start + 1;
		int i = 0;
		while (i < n / 2) {
			swap(arr, start + i, end - i);
			i++;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	public void rotateLeft(int[] arr, int k) {
		if (arr.length == 0)
			return;
		k = k % arr.length;
		ArrayUtil.reverse(arr, 0, k - 1);
		ArrayUtil.reverse(arr, k, arr.length - 1);
		ArrayUtil.reverse(arr);
	}

	public void rotateRight(int[] arr, int k) {
		k = k % arr.length;
		rotateLeft(arr, arr.length - k);
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RotateArray r = new RotateArray();
		r.rotate(arr);
	}

}
