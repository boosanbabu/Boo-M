package dsa.leetcode.medium.graph;

/**
 * https://leetcode.com/problems/surrounded-regions//<br>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 ** 
 * 
 * Example:**<br>
 * 
 * X X X X<br>
 * X O O X <br>
 * X X O X <br>
 * X O X X <br>
 * 
 * 
 * After running your function,the board*should be:**<br>
 * 
 * X X X X <br>
 * X X X X <br>
 * X X X X <br>
 * X O X X
 * 
 * 
 */
public class SurroundedRegions {

	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return;
		if (board.length < 3 || board[0].length < 3)
			return;
		int rows = board.length, cols = board[0].length;
		// Check for 'O's' connected to 'O's borders, these are the one which won't
		// be captured.
		// Mark them all as '*'
		for (int i = 0; i < cols; i++) {
			if (board[0][i] == 'O') {
				dfs(board, 0, i);
			}
			if (board[rows - 1][i] == 'O') {
				dfs(board, rows - 1, i);
			}
		}

		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O') {
				dfs(board, i, 0);
			}
			if (board[i][cols - 1] == 'O') {
				dfs(board, i, cols - 1);
			}
		}

		/*
		 * Now capture all the remaining 'O's and Revert the '*' s to 'O's
		 */
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}

	}

	public void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i > grid.length - 1 || j >= grid[0].length)
			return;
		if (grid[i][j] != 'O')
			return;
		grid[i][j] = '*';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);

	}
}
