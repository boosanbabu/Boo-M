package com.boom.codedaily.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMinMax {
	// Copied
	public int maxOfMinSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n == 0) {
			return -1;
		}
		int max = Integer.MIN_VALUE;
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			/*
			 * If first element in dq is out of window range - remove it
			 */
			if (isNotEmpty(dq) && dq.peek() < i - k + 1) {
				dq.poll();
			}
			/*
			 * While incoming element > last element of dq, remove last
			 */
			while (isNotEmpty(dq) && nums[i] < nums[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.offer(i);
			if (i >= k - 1) {
				max = Math.max(nums[dq.peek()], max);
			}
		}
		return max;
	}

	private boolean isNotEmpty(Deque<Integer> dq) {
		return !dq.isEmpty();
	}

	/*
	 * Find minimum in each sliding window of size k
	 */
	public int[] minSlidingWindow(int[] nums, int k) {
		int n = nums.length, c = 0;
		if (n == 0) {
			return nums;
		}
		int[] result = new int[n - k + 1];
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			// If first element in dq is out of window range - remove it
			if (isNotEmpty(dq) && dq.peek() < i - k + 1) {
				dq.poll();
			}
			// while incoming element is less than last element remove last
			while (isNotEmpty(dq) && nums[i] < nums[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.offer(i);
			if (i >= k - 1) {
				result[c++] = nums[dq.peek()];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SlidingWindowMinMax m = new SlidingWindowMinMax();
		int[] nums = { 1, 3, -1, -3, 5, 3, 5, 3, 6, 7, 6 };
		int k = 3;

		System.out.println(m.maxOfMinSlidingWindow(nums, k));
		Arrays.stream(m.minSlidingWindow(nums, k)).forEach(i -> System.out.print(i + " "));
	}

}
