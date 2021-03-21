package dsa.leetcode.easy.array;

/**
 * 1800. Maximum Ascending Subarray Sum
 * Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.
 * <p>
 * A subarray is defined as a contiguous sequence of numbers in an array.
 * <p>
 * A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi < numsi+1. Note that a subarray of size 1 is ascending.
 *
 */
public class MaxAscSubArrSum {
    public int maxAscendingSum(int[] nums) {
        int result = nums[0];
        int currSum = nums[0];
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>prev) currSum+=nums[i];
            else currSum = nums[i];

            result = Math.max(result,currSum);
            prev = nums[i];
        }
        return result;
    }
}
