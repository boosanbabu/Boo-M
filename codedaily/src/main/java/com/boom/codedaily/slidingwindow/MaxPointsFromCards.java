package com.boom.codedaily.slidingwindow;

/*
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaxPointsFromCards {

	/**
	 * Last k and first k elements form a window of 2k size.
	 * 
	 * In this window, find the sub-array whose sum is minimum
	 * 
	 * Result will be the sum of window minus this minimum sum sub-array,
	 * 
	 * When there is overlap of first and last k elements the entire input array
	 * will be the window.
	 *
	 */
	public int maxScore(int[] cardPoints, int k) {
		int totalCards = cardPoints.length;
		int len = Math.min(2 * k, totalCards);
		if (len == totalCards) {
			int sum = getArraySum(cardPoints);
			int minSum = minSubArraySum(cardPoints, totalCards - k);
			return sum - minSum;
		}
		int[] arr = new int[len];
		for (int i = 0; i < k; i++) {
			arr[i] = cardPoints[i];
			arr[len - 1 - i] = cardPoints[totalCards - 1 - i];
		}
		int minSum = minSubArraySum(arr, len - k);
		return getArraySum(arr) - minSum;
	}

	private int getArraySum(int[] arr) {
		return getArraySum(arr, 0, arr.length);
	}

	private int getArraySum(int[] arr, int s, int e) {
		int sum = 0;
		for (int i = s; i < e; i++) {
			sum += arr[i];
		}
		return sum;
	}

	/**
	 * Find minimum sum from sub-array of size k - Sliding window
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public int minSubArraySum(int[] arr, int k) {
		int sum = getArraySum(arr, 0, k);
		int minSum = sum;
		// Remove first element of window and add last element
		for (int i = k; i < arr.length; i++) {
			sum = sum - arr[i - k] + arr[i];
			minSum = Math.min(minSum, sum);
		}
		return minSum;
	}

	public static void main(String[] args) {
		MaxPointsFromCards m = new MaxPointsFromCards();
		System.out.println(m.maxScore(new int[] { 1, 2, 3, 4, 5, 6, 1 }, 3));
	}
}
