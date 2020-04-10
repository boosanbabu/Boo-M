package com.boom.codedaily.graph;

import java.util.Arrays;

public class DisjointSet {

	int[] parent;

	DisjointSet(int n) {
		parent = new int[n];
	}

	public void makeSet(int i) {
		parent[i] = -1;
	}

	public int findset(int i) {
		if (parent[i] == -1)
			return i;
		int p = findset(parent[i]);
		parent[i] = p;
		return p;
	}

	public boolean union(int i, int j) {
		int iParent = findset(i);
		int jParent = findset(j);
		if (iParent == jParent)
			return false;
		parent[j] = iParent;
		return true;
	}

	public static void main(String[] args) {
		int[][] g = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		DisjointSet d = new DisjointSet(0);
		int[] rs = d.findRedundantConnection(g);
		System.out.print(rs[0] + " " + rs[1]);
	}

	public int[] findRedundantConnection(int[][] edges) {
		int N = 1;
		for (int[] edge : edges) {
			N = Math.max(N, edge[1]);
		}

		int[] parent = new int[N + 1];
		Arrays.fill(parent, -1);
		for (int[] edge : edges) {
			if (!union(parent, edge[0], edge[1])) {
				return edge;
			}
		}
		return null;
	}

	int findParent(int i, int[] parent) {
		if (parent[i] == -1)
			return i;
		int p = findParent(parent[i], parent);
		parent[i] = p;
		return p;
	}

	boolean union(int[] parent, int i, int j) {
		int iParent = findParent(i, parent);
		int jParent = findParent(j, parent);

		if (iParent == jParent)
			return false;
		parent[i] = jParent;
		return true;
	}

}
