package dsa.leetcode.medium.graph;

import java.util.*;

/**
 * 1519. Number of Nodes in the Sub-Tree With the Same Label <br>
 * https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 * 
 * <br>
 * Given a tree (i.e. a connected, undirected graph that has no cycles)
 * consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges. The
 * root of the tree is the node 0, and each node of the tree has a label which
 * is a lower-case character given in the string labels (i.e. The node with the
 * number i has the label labels[i]).
 * 
 * The edges array is given on the form edges[i] = [ai, bi], which means there
 * is an edge between nodes ai and bi in the tree.
 * 
 * Return an array of size n where ans[i] is the number of nodes in the subtree
 * of the ith node which have the same label as node i.
 * 
 * A subtree of a tree T is the tree consisting of a node in T and all of its
 * descendant nodes.
 * 
 * @author boosanbabu
 *
 */
public class NumOfNodesInSubTreeWithSameLabel {

	public int[] countSubTrees(int n, int[][] edges, String labels) {
		Node[] graph = new Node[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new Node(labels.charAt(i), i);
		}
		for (int[] e : edges) {
			graph[e[0]].children.add(graph[e[1]]);
			graph[e[1]].children.add(graph[e[0]]);
		}
		int[] res = new int[n];
		dfs(graph[0], new boolean[n]);
		for (int i = 0; i < n; i++) {
			res[i] = graph[i].charCount[graph[i].label - 'a'];
		}
		return res;
	}

	private void dfs(Node node, boolean visited[]) {
		if (visited[node.key])
			return;
		visited[node.key] = true;
		for (Node c : node.children) {
			if (visited[c.key]) {
				continue;
			}
			dfs(c, visited);
			for (int i = 0; i < 26; i++) {
				node.charCount[i] += c.charCount[i];
			}
		}
	}

	static class Node {
		int key;
		List<Node> children;
		int[] charCount;
		char label;

		Node(char l, int i) {
			label = l;
			key = i;
			children = new ArrayList<>();
			charCount = new int[26];
			charCount[label - 'a'] = 1;
		}
	}

	public static void main(String[] args) {
		NumOfNodesInSubTreeWithSameLabel q = new NumOfNodesInSubTreeWithSameLabel();
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 } };
		int n = 7;
		String labels = "aaabaaa";
		int[] res = q.countSubTrees(n, edges, labels);
		for (int i : res)
			System.out.print(i + " ");
	}

}
