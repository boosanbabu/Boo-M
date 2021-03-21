package dsa.leetcode.medium.dp.strings;


/**
 * 72. Edit Distance <br>
 * https://leetcode.com/problems/edit-distance/ <br>
 * <br>
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * Insert a character <br>
 * Delete a character <br>
 * Replace a character
 * 
 * @author boosanbabu
 *
 */
public class EditDistanceLC {
	public int minDistance(String s1, String s2) {
		System.out.println(bruteForceRecursion(s1, s2, 0, 0));
		System.out.println(recurseMemo(s1, s2, 0, 0, new Integer[s1.length()][s2.length()]));
		int res = iterativeDpSolution(s1, s2);
		return res;
	}

	/**
	 * Time : 3**(M+N)<br>
	 * Space : M+N<br>
	 * 
	 */
	private int bruteForceRecursion(String s1, String s2, int i, int j) {
		if (i == s1.length()) {// If a word is exhausted, remaining word's len. del/insert operation is needed.
			return s2.length() - j;
		}
		if (j == s2.length()) {
			return s1.length() - i;
		}
		if (s1.charAt(i) == s2.charAt(j)) {// If both char are same move to next char in both strings
			return bruteForceRecursion(s1, s2, i + 1, j + 1);
		}
		int insert = bruteForceRecursion(s1, s2, i + 1, j);
		int delete = bruteForceRecursion(s1, s2, i, j + 1);
		int replace = bruteForceRecursion(s1, s2, i + 1, j + 1);

		return Math.min(Math.min(insert, delete), replace) + 1;
	}

	/*
	 * Same as recursive approach but memoize with i,j index in 2-D array
	 */
	private int recurseMemo(String s1, String s2, int i, int j, Integer[][] dp) {

		if (i == s1.length()) {// If a word is exhausted, remaining word's len. del/insert operation is needed.
			return s2.length() - j;
		}
		if (j == s2.length()) {
			return s1.length() - i;
		}
		if (dp[i][j] != null)
			return dp[i][j];
		int res = 0;
		if (s1.charAt(i) == s2.charAt(j)) {// If both char are same move to next char in both strings
			res = recurseMemo(s1, s2, i + 1, j + 1, dp);
		} else {
			int insert = recurseMemo(s1, s2, i + 1, j, dp);
			int delete = recurseMemo(s1, s2, i, j + 1, dp);
			int replace = recurseMemo(s1, s2, i + 1, j + 1, dp);
			res = Math.min(Math.min(insert, delete), replace) + 1;
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
		for (int i = 0; i <= s1.length(); i++) {
			// If there is empty in one word, it means whatever is remaining in other word
			// is the result
			dp[i][0] = i;
		}

		for (int i = 1; i <= s2.length(); i++) {
			dp[0][i] = i;
		}

		for (int i = 0; i < s1.length(); ++i) {
			for (int j = 0; j < s2.length(); ++j) {
				if (s1.charAt(i) == s2.charAt(j)) {
					// Advance pointer in both words. No operation needed.
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]);
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		EditDistanceLC lcs = new EditDistanceLC();
		String s1 = "dellielkoalelkjdsze";
		String s2 = "initialize";
		System.out.println(lcs.minDistance(s1, s2));
	}

}
