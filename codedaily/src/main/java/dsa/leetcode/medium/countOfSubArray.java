package dsa.leetcode.medium;

import java.util.*;

public class countOfSubArray {

	public String destCity(List<List<String>> paths) {
		Set<String> start = new HashSet<>();
		Set<String> end = new HashSet<>();
		for (List<String> p : paths) {
			start.add(p.get(0));
			end.add(p.get(1));
		}
		String res = "";
		for (String e : end) {
			if (!start.contains(e)) {
				res = e;
			}
		}
		return res;
	}

	public boolean kLengthApart(int[] nums, int k) {
		if (k == 0) {
			return true;
		}
		int prev = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				prev = i;
				break;
			}
		}
		for (int i = prev + 1; i < nums.length; i++) {
			if (nums[i] == 1) {
				if ((i - prev) <= k)
					return false;
				prev = i;
			}
		}
		return true;
	}

	public int longestSubarray(int[] nums, int limit) {
		int res = 0, i = 0, j = 0;
		while (i < nums.length) {
			int min = nums[i], max = nums[i];
			for (j = i + 1; j < nums.length; j++) {
				min = Math.min(min, nums[j]);
				max = Math.max(max, nums[j]);
				if (Math.abs(min - max) > limit) {
					break;
				}

			}
			res = Math.max(res, j - i);
			while (i < nums.length - 1 && nums[i] == nums[i + 1])
				i++;
			i++;
		}
		return res;
	}

	public int countTriplets(int[] arr) {
		int res = 0, n = arr.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j; k < n; k++) {
					int xor1 = 0, xor2 = 0;
					for (int x = i; x < j; x++) {
						xor1 ^= arr[x];
					}

					for (int x = j; x <= k; x++) {
						xor2 ^= arr[x];
					}

					if (xor1 == xor2) {
						res++;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		countOfSubArray s = new countOfSubArray();
		int arr[] = { 7, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7,
				11, 12, 9, 5, 2, 7, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17,
				22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11,
				12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5,
				2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11,
				12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5,
				2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17,
				22, 7, 11, 12, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22,
				7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12,
				9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 22, 7, 11, 12, 9, 5, 2, 7, 17, 7, 11, 12, 9, 5, 2, 7,
				17 };

		System.out.println("len " + arr.length);
		System.out.println(s.longestSubarray(arr, 87));
		// System.out.println(s.longestSubarray(new int[] { 4, 2, 2, 2, 4, 4, 2, 2 },
		// 0));
		System.out.println(s.longestSubarray(new int[] { 10, 1, 2, 4, 7, 2 }, 5));
	}

	public static void print(int a[]) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	static final int LIMIT = 31;

	static class TrieNode {

		TrieNode children[];
		int indexSum;
		int indexCount;

		TrieNode() {
			children = new TrieNode[2];
			this.children[0] = null;
			this.children[1] = null;
			this.indexSum = 0;
			this.indexCount = 0;
		}
	};

	static void insert(TrieNode node, int num, int index) {
		for (int bits = LIMIT; bits >= 0; bits--) {
			int curr_bit = (num >> bits) & 1;
			if (node.children[curr_bit] == null) {
				node.children[curr_bit] = new TrieNode();
			}
			node = node.children[curr_bit];
		}
		node.indexSum += index;
		node.indexCount++;
	}

	static int query(TrieNode node, int num, int index) {
		for (int bits = LIMIT; bits >= 0; bits--) {
			int curr_bit = (num >> bits) & 1;
			if (node.children[curr_bit] == null) {
				return 0;
			}
			node = node.children[curr_bit];
		}

		int sz = node.indexCount;
		int sum = node.indexSum;
		int ans = (sz * index) - (sum);
		return ans;
	}

	static int no_of_triplets(int arr[], int n) {
		int currXOR = 0;
		int res = 0;
		TrieNode root = new TrieNode();
		for (int i = 0; i < n; i++) {
			int x = arr[i];
			insert(root, currXOR, i);
			currXOR ^= x;
			res += query(root, currXOR, i);
		}
		return res;
	}
}
