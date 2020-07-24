package dsa.leetcode.medium.array;

public class RemoveDupSortedArr {
	public int removeDuplicates(int[] nums) {
		return linearSolve(nums);
	}

	public int linearSolve(int[] nums) {
		int uniqPtr = 0, i = 0;
		int len = nums.length;
		while (i < len) {
			while (i < len - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
			nums[uniqPtr++] = nums[i++];
		}
		return uniqPtr;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		RemoveDupSortedArr re = new RemoveDupSortedArr();
		re.removeDuplicates(arr);
	}

}
