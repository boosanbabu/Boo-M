package com.boom.codedaily.array;

import java.util.*;

public class DiagnolSort {
	public int[][] diagonalSort(int[][] mat) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				map.putIfAbsent(i - j, new PriorityQueue<>());
				map.get(i - j).add(mat[i][j]);
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = map.get(i - j).poll();
			}
		}
		return mat;
	}

	public static void main(String[] args) {
		DiagnolSort d = new DiagnolSort();
		int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
		d.diagonalSort(mat);
	}

}
