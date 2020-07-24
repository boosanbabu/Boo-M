package dsa.leetcode.medium.slidingwindow;

public class MaxVowelInKWindow {
	public int maxVowels(String s, int k) {
		int result = 0, currMax = 0;
		for (int r = 0, l = 0; l < s.length() - k; r++) {
			if (r - l > k - 1) {
				if (isVowel(s.charAt(l)))
					currMax = Math.max(0, currMax - 1);
				l++;
			}

			if (isVowel(s.charAt(r))) {
				currMax++;
				if (currMax == k)
					return k;
				result = Math.max(currMax, result);
			}
		}
		return result;
	}

	public boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	public static void main(String ar[]) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb.append("a");
		}
		MaxVowelInKWindow mviw = new MaxVowelInKWindow();
		System.out.println(mviw.maxVowels(sb.toString(), 10000));
	}
}