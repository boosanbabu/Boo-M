package com.boom.codedaily.hashtable;

import java.util.*;

public class DiagnolTraverse {
	/*
	 * Idea is to use the property of diagonal elements i+j is same for all elements
	 * in a diagonal.
	 * 
	 * Traverse each row and each column i,j from 0 to length
	 * 
	 * Use i+j as key for map and add all elements to a list (here use stack)
	 */
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		Map<Integer, Stack<Integer>> map = new LinkedHashMap<>();
		int c = 0;
		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < nums.get(i).size(); j++) {
				map.putIfAbsent(i + j, new Stack<>());
				map.get(i + j).push(nums.get(i).get(j));
				c++;
			}
		}
		int[] res = new int[c];
		int i = 0;
		for (Stack<Integer> stack : map.values()) {
			while (!stack.isEmpty())
				res[i++] = stack.pop();
		}
		return res;
	}

	public static void main(String[] args) {
		DiagnolTraverse d = new DiagnolTraverse();
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		nums.add(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));
		nums.add(Arrays.asList(new Integer[] { 6, 7, 11, 12 }));
		nums.add(Arrays.asList(new Integer[] { 8 }));
		nums.add(Arrays.asList(new Integer[] { 9, 10, 11 }));

		d.findDiagonalOrder(nums);
	}

}
