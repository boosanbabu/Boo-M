package com.boom.codedaily.medium.graph;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					markVisitedAndCheckNeighbour(grid, i, j);
					res = res + 1;
				}
			}
		}
		return res;
	}

	public boolean isWithinBoundary(int i, int j, int R, int C) {
		return (i >= 0 && i < R && j >= 0 && j < C);
	}

	public void markVisitedAndCheckNeighbour(char[][] grid, int i, int j) {
		grid[i][j] = 0;
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int[] dir : directions) {
			int x = i + dir[0];
			int y = j + dir[1];

			if (isWithinBoundary(x, y, grid.length, grid[0].length) && grid[x][y] == '1') {
				markVisitedAndCheckNeighbour(grid, x, y);
			}
		}
	}

	public static void main(String[] args) {
		String testString = "asfdl;kjfa\t\tdsasdf ";
		String nonPrintablechar = "[^\\x00-\\x1F]*";
		Pattern regexPattern = Pattern.compile(nonPrintablechar);
		Matcher matcher = regexPattern.matcher(testString);
		boolean regexMatched = matcher.matches();
		System.out.println(regexMatched);

		matcher = regexPattern.matcher(" sd aff ");
		System.out.println(matcher.matches());
		
		matcher = regexPattern.matcher(" sd \naff ");
		System.out.println(matcher.matches());
		
		matcher = regexPattern.matcher(" sd a@#@$$@#$@#$ff ");
		System.out.println(matcher.matches());
		
		matcher = regexPattern.matcher(" sd a@#@$$\r@#$@#$ff ");
		System.out.println(matcher.matches());
		
		matcher = regexPattern.matcher(" sd a@#@$$\r@#$@#$ff ");
		System.out.println(matcher.matches());


	}
}
