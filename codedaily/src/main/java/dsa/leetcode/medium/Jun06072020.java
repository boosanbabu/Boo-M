package dsa.leetcode.medium;

import java.util.*;

public class Jun06072020 {
	public int[] getStrongest(int[] arr, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i : arr) {
			list.add(i);
		}
		Arrays.sort(arr);
		int m = arr[(arr.length - 1) / 2];
		list.sort((a, b) -> Math.abs(b - m) != Math.abs(a - m) ? (Math.abs(b - m) - Math.abs(a - m)) : b - a);
		int res[] = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public static void main(String a[]) {
		Jun06072020 j = new Jun06072020();
		j.getStrongest(new int[] {6,-3,7,2,11 }, 2);
	}
}
