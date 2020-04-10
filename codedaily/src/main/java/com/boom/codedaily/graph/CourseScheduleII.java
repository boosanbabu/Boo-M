package com.boom.codedaily.graph;

import java.util.*;

public class CourseScheduleII {
	public int[] findOrder(int n, int[][] prerequisites) {
		List<Integer>[] adjList = new List[n];
		for (int i = 0; i < n; i++)
			adjList[i] = new ArrayList<>();
		for (int[] conn : prerequisites) {
			adjList[conn[0]].add(conn[1]);
		}
		boolean[] visited = new boolean[n];
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			explore(visited, adjList, i, stack);
		}
		if (stack.size() != n)
			return new int[0];
		int[] res = new int[stack.size()];
		int i = 0;
		while (!stack.isEmpty()) {
			res[i++] = stack.pop();
		}
		return res;
	}

	public void explore(boolean[] visited, List<Integer>[] adjList, int i, Deque<Integer> stack) {
		for (Integer c : adjList[i]) {
			if (visited[c])
				continue;
			visited[c] = true;
			explore(visited, adjList, c, stack);
		}
		stack.push(i);
	}

	public static void invoke(int[][] arr, int n) {
		System.out.println();
		CourseScheduleII a = new CourseScheduleII();
		int res[] = a.findOrder(n, arr);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		invoke(new int[][] { { 1, 0 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 2, 7 }, { 3, 7 }, { 4, 7 } }, 8);
		invoke(new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } }, 4);
	}

}
