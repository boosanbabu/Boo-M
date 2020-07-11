package com.boom.codedaily.array;

public class GameOfLife {

	private static final int ZERO_TO_ONE = 2;
	private static final int ONE_TO_ZERO = 3;

	public void gameOfLife(int[][] board) {
		if (board.length == 0)
			return;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				int liveNeighbours = getLiveNeighbourCount(board, i, j);
				applyRuleTransform(board, i, j, liveNeighbours);
			}
		reTransformBoard(board);
	}

	/*
	 * Apply rules and transform the current cell
	 */
	public void applyRuleTransform(int[][] board, int i, int j, int liveNeighbours) {
		if (board[i][j] % 2 == 1 && (liveNeighbours < 2 || liveNeighbours > 3)) {
			board[i][j] = ONE_TO_ZERO;
		} else if (liveNeighbours == 3)
			board[i][j] = ZERO_TO_ONE;
	}

	private void reTransformBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == ONE_TO_ZERO)
					board[i][j] = 0;
				else if (board[i][j] == ZERO_TO_ONE)
					board[i][j] = 1;
			}
		}
	}

	public int getLiveNeighbourCount(int[][] board, int i, int j) {
		int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		int live = 0;
		if(i==2 && j==2) {
			System.out.println();
		}
		for (int[] di : dir) {
			int ni = di[0] + i, nj = di[1] + j;
			if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length 
					&& board[ni][nj] % 2 == 1)
				live++;
		}
		return live;
	}

	public static void main(String[] args) {
		GameOfLife g = new GameOfLife();
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		g.gameOfLife(board);
		ArrayUtil.print(board);
	}
}
