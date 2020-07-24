package dsa.leetcode.medium.array;

public class MaxRainWaterTrap {
	public int trap(int[] height) {
		System.out.println(dpMemoize(height));
		return brute(height);
	}

	/*
	 * BRUTE FORCE 1. For each element find tallestToLeft and tallestToRight 2.
	 * Smallest of the two minus curr height is the amount of water that could be
	 * trapped in that block 3. add that to result
	 */
	public int brute(int[] height) {
		int res = 0, len = height.length;
		for (int i = 1; i < len - 1; i++) {
			int tallestToLeft = getLargest(0, i, height);
			int tallestToRight = getLargest(i + 1, len, height);
			int max = Math.min(tallestToLeft, tallestToRight);
			if (max > height[i])
				res += max - height[i];
		}
		return res;
	}

	public int getLargest(int start, int end, int[] arr) {
		int max = 0;
		for (int i = start; i < end; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}

	/*
	 * 1. For each element find tallestToLeft, tallestToRight and store that as
	 * table 2. Minimum of the maximum minus curr. height is the water that can be
	 * trapped for each element
	 */
	public int dpMemoize(int[] height) {
		int res = 0, len = height.length;
		if (len == 0)
			return res;

		int[] tallestToRight = new int[len], tallestToLeft = new int[len];
		for (int i = 1; i < len; i++) {
			tallestToLeft[i] = Math.max(tallestToLeft[i - 1], height[i - 1]);
		}
		for (int i = len - 2; i >= 0; i--) {
			tallestToRight[i] = Math.max(tallestToRight[i + 1], height[i + 1]);
		}

		for (int i = 1; i < len - 1; i++) {
			int max = Math.min(tallestToLeft[i], tallestToRight[i]);
			if (max > height[i])
				res += max - height[i];
		}
		return res;
	}

	public static void main(String[] args) {
		MaxRainWaterTrap m = new MaxRainWaterTrap();
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(m.trap(height));
	}

}
