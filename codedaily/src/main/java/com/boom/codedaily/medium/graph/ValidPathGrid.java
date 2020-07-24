package com.boom.codedaily.medium.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidPathGrid {
	static final Map<Integer, Direction[]> STATE_MAP = new HashMap<>();

	public boolean hasValidPath(int[][] grid) {
		STATE_MAP.put(1, new Direction[] { Direction.RIGHT, Direction.LEFT });
		STATE_MAP.put(2, new Direction[] { Direction.UP, Direction.DOWN });
		STATE_MAP.put(3, new Direction[] { Direction.LEFT, Direction.DOWN });
		STATE_MAP.put(4, new Direction[] { Direction.RIGHT, Direction.DOWN });
		STATE_MAP.put(5, new Direction[] { Direction.LEFT, Direction.UP });
		STATE_MAP.put(6, new Direction[] { Direction.RIGHT, Direction.UP });

		return dfs(grid, 0, 0, new boolean[grid.length][grid[0].length]);
	}

	private static enum Direction {
		UP(2, 3, 4), DOWN(2, 5, 6), LEFT(1, 4, 6), RIGHT(1, 3, 5);
		int[] nextAllowedStates;

		Direction(int... arr) {
			nextAllowedStates = Arrays.copyOf(arr, arr.length);
		}
	}

	private boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
		if (i == grid.length - 1 && j == grid[0].length - 1)
			return true;
		if (visited[i][j])
			return false;
		visited[i][j] = true;
		int currState = grid[i][j];
		if (!canMove(grid, i, j, STATE_MAP.get(currState), visited))
			return false;
		visited[i][j] = false;
		return true;

	}

	private boolean canMove(int[][] grid, int i, int j, Direction[] dir, boolean[][] visited) {
		boolean res = false;
		for (Direction d : dir) {
			switch (d) {
			case RIGHT:
				if (j + 1 < grid[0].length && contains(grid[i][j + 1], d.nextAllowedStates))
					res = res || dfs(grid, i, j + 1, visited);
				break;
			case UP:
				if (i - 1 >= 0 && contains(grid[i - 1][j], d.nextAllowedStates))
					res = res || dfs(grid, i - 1, j, visited);
				break;
			case DOWN:
				if (i + 1 < grid.length && contains(grid[1 + i][j], d.nextAllowedStates))
					res = res || dfs(grid, i + 1, j, visited);
				break;
			case LEFT:
				if (j - 1 >= 0 && contains(grid[i][j - 1], d.nextAllowedStates))
					res = res || dfs(grid, i, j - 1, visited);
				break;
			}
		}
		return res;
	}

	public static boolean contains(int i, int... arr) {
		for (int a : arr) {
			if (i == a)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
