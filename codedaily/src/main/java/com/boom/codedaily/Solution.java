package com.boom.codedaily;

import java.util.*;

import com.boom.codedaily.common.TreeNode;

class Solution {
	private static final int nine = 9;

	public int maxPower(String s) {
		int max = 0, currMax = 1;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i), p = s.charAt(i - 1);
			if (p == c) {
				currMax++;
			} else {
				currMax = 1;
			}
			max = Math.max(currMax, max);

		}
		return max;
	}

	public List<String> simplifiedFractions(int n) {
		List<String> res = new ArrayList<>();
		for (int numerator = 1; numerator < n; numerator++) {
			for (int d = 2; d <= n; d++) {
				int lcm = lcm(d, numerator);
				if (lcm == numerator * d && numerator / d == 0) {
					res.add(numerator + "/" + d);
				}

			}
		}
		return res;
	}

	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	// method to return LCM of two numbers
	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	public static class Result {
		int res;
	}

	public int goodNodes(TreeNode root) {
		Result r = new Result();
		r.res = 0;
		goodNode(root, Integer.MIN_VALUE, r);
		return r.res;
	}

	public void goodNode(TreeNode node, int max, Result r) {
		if (node == null)
			return;
		if (node.val > max)
			r.res += 1;
		int newMax = Math.max(max, node.val);
		goodNode(node.left, newMax, r);
		goodNode(node.right, newMax, r);
	}

	public static void main(String ar[]) {
		Solution s = new Solution();

		List<List<String>> favoriteCompanies = new ArrayList<>();
		String[][] list = { { "leetcode", "google", "facebook" }, { "google", "microsoft" }, { "google", "facebook" },
				{ "google" }, { "amazon" } };
		for (String[] arr : list) {
			favoriteCompanies.add(Arrays.asList(arr));
		}
		s.peopleIndexes(favoriteCompanies);

	}

	static void printknapSack(int target, int cost[]) {
		int i, w;
		int dp[][] = new int[9 + 1][target + 1];

		for (i = 0; i <= 9; i++) {
			for (w = 0; w <= target; w++) {
				if (i == 0 || w == 0)
					dp[i][w] = 0;
				else if (cost[i - 1] <= w)
					dp[i][w] = Math.max((i - 1) + dp[i - 1][w - cost[i - 1]], dp[i - 1][w]);
				else
					dp[i][w] = dp[i - 1][w];
			}
		}

		int res = dp[9][target];
		System.out.println(res);

		w = target;
		for (i = 9; i > 0 && res > 0; i--) {

			if (res == dp[i - 1][w])
				continue;
			else {

				System.out.print(cost[i - 1] + " ");

				res = res - (i - 1);
				w = w - cost[i - 1];
			}
		}
	}

	public String arrangeWords(String text) {
		String[] words = text.split(" ");
		int minLen = Integer.MAX_VALUE, maxLen = 0;
		for (String w : words) {
			minLen = Math.min(minLen, w.length());
			maxLen = Math.max(maxLen, w.length());
		}
		words[0] = words[0].toLowerCase();
		LinkedList<String>[] byLen = new LinkedList[maxLen + 1];
		for (String w : words) {
			int len = w.length();
			if (byLen[len] == null) {
				byLen[len] = new LinkedList<>();
			}
			byLen[len].add(w);
		}

		int w = 0;
		for (int i = minLen; i < byLen.length; i++) {
			if (byLen[i] == null) {
				continue;
			}
			for (String s : byLen[i]) {
				words[w++] = s;
			}
		}
		words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1).toLowerCase();
		text = String.join(" ", words);
		return text;
	}

	public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
		List<Set<String>> favComps = new ArrayList<>();
		for (List<String> comp : favoriteCompanies) {
			favComps.add(new HashSet<>(comp));
		}
		int i = 0;
		List<Integer> res = new ArrayList<>();
		for (Set<String> set : favComps) {
			boolean isSubSet = false;
			for (Set<String> otherSet : favComps) {
				if (set.equals(otherSet))
					continue;
				if (otherSet.containsAll(set)) {
					isSubSet = true;
					break;
				}
			}
			if (!isSubSet)
				res.add(i);
			i++;
		}
		return res;
	}
}
