package dsa.leetcode.medium.array;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix
 * 
 * Given a m * n matrix of distinct numbers, 
 * return all lucky numbers in the matrix in any order.
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 */
public class LuckyNumbersMatrix {

	public List<Integer> luckyNumbers(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int[] rowMins = new int[matrix.length];
		int[] colMaxs = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			rowMins[i] = Integer.MAX_VALUE;
			for (int j = 0; j < matrix[0].length; j++) {
				rowMins[i] = Math.min(rowMins[i], matrix[i][j]);
			}
		}

		for (int j = 0; j < matrix[0].length; j++) {
			colMaxs[j] = Integer.MIN_VALUE;
			for (int i = 0; i < matrix.length; i++) {
				colMaxs[j] = Math.max(colMaxs[j], matrix[i][j]);
			}
		}

		if (colMaxs.length < rowMins.length) {
			for (int c : colMaxs) {
				for (int r : rowMins) {
					if (c == r) {
						res.add(c);
					}
				}
			}
		} else {
			for (int r : rowMins) {
				for (int c : colMaxs) {
					if (c == r) {
						res.add(c);
					}
				}
			}
		}
		return res;
	}

}
