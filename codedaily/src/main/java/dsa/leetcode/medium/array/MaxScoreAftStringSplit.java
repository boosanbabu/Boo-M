package dsa.leetcode.medium.array;

public class MaxScoreAftStringSplit {

	/*
	 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
	 * 
	 * 1. Find totalZeroes in the input.
	 * 
	 * 2. Iterate array again, keep track of cumulative zero count up to current
	 * index.
	 * 
	 * 3.Now we can find number of zeroes to the right of current index, using which
	 * we can find count of ones to the right and maximize the score
	 *
	 */
	public int maxScore(String s) {
		int len = s.length(), totalZero = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0')
				totalZero++;
		}

		int maxScore = 0;
		int currZ = 0; // total zeroes upto curr. point
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '0')
				currZ++;
			int rightSideOneCount = (len - i - 1) - (totalZero - currZ);
			maxScore = Math.max(maxScore, currZ + rightSideOneCount);
		}
		System.out.println(maxScore);
		return maxScore;
	}

	public static void main(String[] args) {
		MaxScoreAftStringSplit m = new MaxScoreAftStringSplit();
		m.maxScore("1111");
	}

}
