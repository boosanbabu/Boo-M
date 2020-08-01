package dsa.interviews.graph.masaischool;

import java.util.*;
import java.util.Map.Entry;

/**
 * Find size of all islands<br>
 * Print total number of islands and <br>
 * Print size of island to count of island
 * 
 * @author boosanbabu
 *
 */
public class DEAProblem {

	public static void main(String args[]) {
		int graph[][] = new int[][] { { 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
				{ 1, 1, 1, 1, 1 } };
		countIslandsSizeSorted(graph.length, graph[0].length, graph);
	}

	static class IntWrapper {
		int c = 1;
	}

	private static void countIslandsSizeSorted(int r, int c, int[][] graph) {
		List<Integer> islandSize = new ArrayList<>();
		boolean visited[][] = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j] && graph[i][j] == 1) {
					IntWrapper count = new IntWrapper();
					IntWrapper res = DFS(i, j, graph, visited, count);
					islandSize.add(res.c);
				}
			}
		}
		System.out.println(islandSize.size());
		Map<Integer, Integer> freqMap = new TreeMap<>();// Sort by size of island.
		for (int f : islandSize) {
			freqMap.put(f, freqMap.getOrDefault(f, 0) + 1);
		}
		for (Entry<Integer, Integer> e : freqMap.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}

	private static IntWrapper DFS(int row, int column, int graph[][], boolean[][] visited, IntWrapper count) {
		int rowBoundry[] = new int[] { -1, 1, 0, 0 };
		int columnBoundry[] = new int[] { 0, 0, 1, -1 };

		visited[row][column] = true;
		for (int i = 0; i < 4; i++) {
			if (isSafe(row + rowBoundry[i], column + columnBoundry[i], graph, visited)) {
				count.c++;
				DFS(row + rowBoundry[i], column + columnBoundry[i], graph, visited, count);
			}
		}
		return count;
	}

	private static boolean isSafe(int row, int column, int graph[][], boolean[][] visited) {
		return ((row < graph.length && row >= 0) && (column < graph[0].length && column >= 0) && !visited[row][column]
				&& graph[row][column] == 1);
	}
}