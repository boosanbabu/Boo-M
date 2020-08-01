package dsa.leetcode.easy.sort;

import java.util.*;

/* goldman-sachs, heap
 * 
 * 1086. High Five
 * https://leetcode.com/problems/high-five/
 * 
	Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
	
	Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
	
	 
	
	Example 1:
	
	Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
	Output: [[1,87],[2,88]]
	Explanation: 
	The average of the student with id = 1 is 87.
	The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
	
	Note:

	1 <= items.length <= 1000
	items[i].length == 2
	The IDs of the students is between 1 to 1000
	The score of the students is between 1 to 100
	For each student, there are at least 5 scores
 */
public class HighFive {

	public int[][] highFive(int[][] items) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int[] score : items) {
			PriorityQueue<Integer> pq = map.getOrDefault(score[0], new PriorityQueue<>(5));
			if (pq.isEmpty()) {
				pq.offer(score[1]);
			} else {
				pq.offer(score[1]);
				if (pq.size() > 5) {
					pq.poll();
				}
			}
			map.put(score[0], pq);
		}

		int[][] res = new int[map.size()][2];
		int i = 0;
		for (int id : map.keySet()) {
			PriorityQueue<Integer> pq = map.get(id);
			int sum = 0;
			while (!pq.isEmpty()) {
				sum += pq.poll();
			}
			res[i][0] = id;
			res[i][1] = sum / 5;
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		HighFive f = new HighFive();
		int[][] items = { { 1, 91 }, { 1, 92 }, { 2, 93 }, { 2, 97 }, { 1, 60 }, { 2, 77 }, { 1, 65 }, { 1, 87 },
				{ 1, 100 }, { 2, 100 }, { 2, 76 }, { 1, 66 } };
		f.highFive(items);
	}

}
