package dsa.leetcode.medium.string;

import java.util.*;

/*
 * 1525. Number of Good Ways to Split a String
 * 
 * 
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 * 
	You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q where its concatenation is equal to s and the number of distinct letters in p and q are the same.
	Return the number of good splits you can make in s.
	
	Input: s = "aacaba"
	Output: 2
	Explanation: There are 5 ways to split "aacaba" and 2 of them are good. 
	("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
	("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
	("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
	("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
	("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
 */
public class NoOfGoodWaysToSplit {
	/*
	 * Store the counts of distinct letters in the left and right substring divided
	 * by the current index.
	 */
	public int numSplits(String s) {
		int len = s.length();
		int[] uniqCharCountFromLeft = new int[len];
		int[] uniqCharCountFromRight = new int[len + 1];

		Set<Character> uniqCharSetL = new HashSet<>();
		Set<Character> uniqCharSetR = new HashSet<>();

		for (int i = 0; i < len; i++) {
			uniqCharSetL.add(s.charAt(i));
			uniqCharSetR.add(s.charAt(len - 1 - i));
			uniqCharCountFromLeft[i] = uniqCharSetL.size();
			uniqCharCountFromRight[len - 1 - i] = uniqCharSetR.size();
		}

		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (uniqCharCountFromLeft[i] == uniqCharCountFromRight[i + 1])
				res++;
		}
		return res;
	}

	public int numSplitsSpaceOptimal(String s) {
		int n = s.length();
		int[] left = new int[26];
		int[] right = new int[26];
		Arrays.fill(left, -1);
		Arrays.fill(right, -1);

		for (int i = 0; i < n; i++) {
			right[s.charAt(i) - 'a'] = i;
			left[s.charAt(n - 1 - i) - 'a'] = i;
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			int x = 0, y = 0;
			for (int j = 0; j < 26; j++)
				if (left[j] != -1 && left[j] <= i)
					x++;
			for (int j = 0; j < 26; j++)
				if (right[j] != -1 && right[j] > i)
					y++;
			ans += x == y ? 1 : 0;
		}
		return ans;
	}

	public static void main(String aa[]) {
		NoOfGoodWaysToSplit n = new NoOfGoodWaysToSplit();
		System.out.println(n.numSplits("acbadbaada"));
		System.out.println(n.numSplitsSpaceOptimal("acbadbaada"));
	}

}
