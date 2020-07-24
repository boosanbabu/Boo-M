package com.boom.codedaily.tree.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTimeToCollectApples {
	/**
	 * Key Notes:
	 * 
	 * You need to consume 2 seconds to simply collect an apple node (come and
	 * go)<br>
	 * Consider a node: <br>
	 * If none of descendant has an apple, we don't need to waste time on this
	 * node<br>
	 * If any of descendant has an apple, we need to consume 2 seconds on this node
	 * Collect node 0 does not need to consume any time <br>
	 * Then, we can have a helper dfs function meaning: time needs to waste on this
	 * node to collect all apples. (0 or > 0).*
	 */
	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		TreeNode[] nodes = new TreeNode[n];
		constructTree(n, edges, hasApple, nodes);
		return dfs(0, nodes, new boolean[n]);
	}

	private int dfs(int i, TreeNode[] nodes, boolean[] visited) {
		TreeNode curr = nodes[i];
		visited[curr.num] = true;
		int res = 0;
		for (TreeNode c : curr.connections) {
			if (visited[c.num])
				continue;
			res += dfs(c.num, nodes, visited);
		}
		// If curr has apple or any of it's child as apple then add 2 to result.
		if ((res > 0 || curr.hasApple) && i != 0)
			res += 2;
		return res;
	}

	private void constructTree(int n, int[][] edges, List<Boolean> hasApple, TreeNode[] nodes) {
		for (int i = 0; i < n; i++) {
			nodes[i] = new TreeNode(i, hasApple.get(i));
		}

		for (int[] edge : edges) {
			TreeNode n1 = nodes[edge[0]];
			TreeNode n2 = nodes[edge[1]];
			n1.connections.add(n2);
			n2.connections.add(n1);
		}
	}

	static class TreeNode {
		int num;
		boolean hasApple;
		List<TreeNode> connections;

		public TreeNode(int v, Boolean apple) {
			num = v;
			hasApple = apple;
			connections = new ArrayList<>();
		}
	}

	public static void main(String[] args) {
		MinTimeToCollectApples m = new MinTimeToCollectApples();
		int n = 7;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		List<Boolean> hasApple = Arrays.asList(new Boolean[] { false, false, true, false, true, true, false });
		System.out.println(m.minTime(n, edges, hasApple));
	}
}
