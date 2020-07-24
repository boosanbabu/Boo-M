package dsa.leetcode.medium.graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {

	public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		int[] indegree = new int[numCourses];
		List<Integer> adjList[] = new ArrayList[numCourses];

		for (int i = 0; i < numCourses; i++)
			adjList[i] = new ArrayList<>();

		for (int row[] : prerequisites) {
			indegree[row[0]]++;
			adjList[row[1]].add(row[0]);
		}

		// Add independent courses to q
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		int i = 0;
		// Do BFS - Decrement inflow each time you go to a child
		// If there are no further inflows to a child,
		// it means child course is ready to be taken
		while (!q.isEmpty()) {
			int curr = q.poll();
			res[i++] = curr;
			for (int child : adjList[curr]) {
				indegree[child]--;
				if (indegree[child] == 0)
					q.add(child);
			}
		}
		// If all courses are filled in result.
		if (i == numCourses)
			return res;
		return new int[0];
	}

	public static void main(String[] args) {
		TopologicalSort a = new TopologicalSort();
		int[][] arr = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 4, 5 }, { 2, 4 }, { 5, 7 }, { 7, 3 }, { 7, 6 } };
		a.canFinish(8, arr);
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] completed = new int[numCourses];
		Arrays.fill(completed, 1);
		Map<Integer, List<Integer>> fromTo = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			fromTo.put(i, new ArrayList<>());
		}
		for (int[] preReq : prerequisites) {
			if (completed[preReq[1]] == 1)
				completed[preReq[1]] = 0;
			fromTo.get(preReq[1]).add(preReq[0]);
		}
		// dfs(fromTo, 0);
		topoUsingBFS(numCourses, prerequisites);
		findOrder(numCourses, prerequisites);
		findOrderBFS(numCourses, prerequisites);
		return true;
	}

	public boolean topoUsingBFS(int numCourses, int[][] prerequisites) {
		int[] inDegree = new int[numCourses];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int[] toFrom : prerequisites) {
			int to = toFrom[0];
			int from = toFrom[1];
			inDegree[to]++;
			graph.get(from).add(to);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int child : graph.get(curr)) {
				inDegree[child]--;
				if (inDegree[child] == 0)
					q.add(child);
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] > 0)
				return false;
		}
		return true;
	}

	// https://leetcode.com/problems/course-schedule-ii/
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		int[] indegree = new int[numCourses];
		List<Integer> adjList[] = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			adjList[i] = new ArrayList<>();

		for (int row[] : prerequisites) {
			indegree[row[0]]++;
			adjList[row[1]].add(row[0]);
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		int i = 0;
		while (!q.isEmpty()) {
			int curr = q.poll();
			res[i++] = curr;
			for (int child : adjList[curr]) {
				indegree[child]--;
				if (indegree[child] == 0)
					q.add(child);
			}
		}
		return res;
	}
}