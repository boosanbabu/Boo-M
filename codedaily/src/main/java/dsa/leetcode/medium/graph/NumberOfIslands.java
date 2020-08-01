package dsa.leetcode.medium.graph;

/**
 * https://leetcode.com/problems/number-of-islands/<br>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * @author boosanbabu
 *
 */
public class NumberOfIslands {

	public int numIslandsEasyToUnderstand(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					// Found an island, start visiting its neighboring islands and mark them visited
					sinkIsland(grid, i, j);
					result++; // Add on to the result, as this marks 1 island cluster
				}
			}
		}
		return result;
	}

	public void sinkIsland(char[][] grid, int i, int j) {
		if (i >= grid.length || i < 0 || j < 0 || j >= grid[0].length)
			return;
		if (grid[i][j] != '1')
			return;
		grid[i][j] = 'X';// Marking the island sinked (visited), so that we avoid re-visiting it again
		sinkIsland(grid, i + 1, j);
		sinkIsland(grid, i - 1, j);
		sinkIsland(grid, i, j + 1);
		sinkIsland(grid, i, j - 1);
	}

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

}
