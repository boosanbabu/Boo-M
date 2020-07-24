package com.boom.codedaily.medium.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Leetcode 207 : https://leetcode.com/problems/course-schedule/
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * 
 * Output: true
 * 
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		return dfsBasedTopologicalSort(numCourses, prerequisites);
		// return kahnsTopologicalSort(numCourses, prerequisites);
	}

	public boolean kahnsTopologicalSort(int numCourses, int[][] prerequisites) {
		return false;
	}

	public boolean dfsBasedTopologicalSort(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new List[numCourses];
		// Construct graph
		for (int[] path : prerequisites) {
			if (graph[path[1]] == null)
				graph[path[1]] = new ArrayList<>();
			graph[path[1]].add(path[0]);
		}
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i])
				dfs(visited, graph, i, stack);
		}

		return stack.size() == numCourses;
	}

	private void dfs(boolean[] visited, List<Integer>[] graph, int i, Stack<Integer> stack) {
		visited[i] = true;
		if (graph[i] == null || graph[i].isEmpty()) {
			return;
		}
		for (Integer child : graph[i]) {
			if (!visited[child])
				dfs(visited, graph, child, stack);
		}
		stack.push(i);
	}

	public static void main(String[] args) {
		CourseSchedule o = new CourseSchedule();

		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 } };
		System.out.println(o.canFinish(numCourses, prerequisites));
		System.out.println(o.kahnsTopologicalSort(numCourses, prerequisites));

		prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
		System.out.println(o.canFinish(numCourses, prerequisites));
		System.out.println(o.kahnsTopologicalSort(numCourses, prerequisites));
	}
}
