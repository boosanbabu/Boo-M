package dsa.leetcode.medium.array;

import java.util.*;

/*
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2

 */
public class SubArraySum {
	/**
	 * Have a running sum and store the num. of times a particular sum occurs in a
	 * map.
	 * 
	 * By this map to compute sum(i,j) -> we could use sum(0,j) and sum(0,i-1)
	 * 
	 */
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> prefixSum = new HashMap<>();
		prefixSum.put(0, 1);// This is important, cos initially the sum is 0 and occurs one time
		// Needed for cases where the target sum is starting from first element
		int currSum = 0, res = 0;
		for (int i : nums) {
			currSum += i;
			prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
			res += prefixSum.getOrDefault(currSum - k, 0);
		}
		return res;
	}

	public static void main(String[] args) {
		SubArraySum s = new SubArraySum();
		int[] nums = { 1, 1, -1, 0, -2, 1, 2, 3, -1, 1, 4, 1, 5, 3, 2, -1, 4, 4, -3, 1 };
		int k = 5;
		System.out.println(s.subarraySum(nums, k));
	}
}
