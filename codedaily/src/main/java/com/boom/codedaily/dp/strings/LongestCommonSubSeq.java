package com.boom.codedaily.dp.strings;

/**
 * 1143. Longest Common Subsequence <br>
 * https://leetcode.com/problems/longest-common-subsequence/ <br>
 * <br>
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative order
 * of the remaining characters. (eg, "ace" is a subsequence of "abcde" while
 * "aec" is not). <br>
 * 
 * A common subsequence of two strings is a subsequence that is common to both
 * strings. If there is no common subsequence, return 0.
 * 
 * @author boosanbabu
 *
 */
public class LongestCommonSubSeq {
	public int longestCommonSubsequence(String s1, String s2) {
		System.out.println("Brute force " + bruteForceRecursion(s1, s2, 0, 0));
		System.out.println("Recursion memo " + recurseMemo(s1, s2, 0, 0, new Integer[s1.length()][s2.length()]));
		return iterativeDpSolution(s1, s2);
	}

	/**
	 * Time : 2**(M+N)<br>
	 * Space : M+N<br>
	 * 
	 */
	private int bruteForceRecursion(String s1, String s2, int i, int j) {
		if (i >= s1.length() || j >= s2.length()) {// Exit condition
			return 0;
		}
		if (s1.charAt(i) == s2.charAt(j)) {// If both char are same move to next char in both strings
			return bruteForceRecursion(s1, s2, i + 1, j + 1) + 1;
		}
		// If not, tree can be going by next char in one string but same char in other
		// and vice versa.
		return Math.max(bruteForceRecursion(s1, s2, i + 1, j), bruteForceRecursion(s1, s2, i, j + 1));
	}

	/*
	 * Same as recursive approach but memoize with i,j index in 2-D array
	 */
	private int recurseMemo(String s1, String s2, int i, int j, Integer[][] dp) {
		if (i >= s1.length() || j >= s2.length()) {// Exit condition
			return 0;
		}
		if (dp[i][j] != null)
			return dp[i][j];
		int res;
		if (s1.charAt(i) == s2.charAt(j)) {// If both char are same move to next char in both strings
			res = recurseMemo(s1, s2, i + 1, j + 1, dp) + 1;
		} else {
			// If not, tree can be going by next char in one string but same char in other
			// and vice versa.
			res = Math.max(recurseMemo(s1, s2, i + 1, j, dp), recurseMemo(s1, s2, i, j + 1, dp));
		}
		dp[i][j] = res;
		return res;
	}

	/*
	 * Look at DP array, initialize 1 size more to avoid the zero corner case
	 * checks.
	 */
	private int iterativeDpSolution(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < s1.length(); ++i) {
			for (int j = 0; j < s2.length(); ++j) {
				if (s1.charAt(i) == s2.charAt(j))
					dp[i + 1][j + 1] = 1 + dp[i][j];
				else
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
			}
		}
		return dp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		LongestCommonSubSeq lcs = new LongestCommonSubSeq();
		String s1 = "dijnopzxyz";
		String s2 = "degxy";
		lcs.longestCommonSubsequence(s1, s2);
	}

}
