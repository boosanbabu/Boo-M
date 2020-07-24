package dsa.leetcode.medium.array;

import java.util.*;

public class FindTheDistanceValue {
	public int findTheDistanceValue(final int[] arr1, final int[] arr2, final int d) {
		int res = 0;
		for (final int a : arr1) {
			boolean count = true;
			for (final int b : arr2) {
				final int abs = Math.abs(a - b);
				if (abs <= d) {
					count = false;
					break;
				}
			}
			if (count)
				res++;
		}
		return res;
	}

	public int getKth(final int lo, final int hi, final int k) {
		final int size = hi - lo + 1;
		final int map[] = new int[1001];
		for (int i = 1; i < 1001; i++) {
			map[i] = findPow(i);
		}
		final Integer res[] = new Integer[size];
		for (int i = 0; i < size; i++) {
			res[i] = lo + i;
		}
		Arrays.sort(res, (a, b) -> {
			if (map[a] == map[b]) {
				return a - b;
			}
			return map[a] - map[b];
		});
		return res[k - 1];
	}

	private static int findPow(int i) {
		int step = 0;
		while (!isPowOf2(i)) {
			step++;
			if (i % 2 == 0)
				i = i / 2;
			else
				i = 3 * i + 1;
		}
		step += log2(i);
		return step;
	}

	public static boolean isPowOf2(final int x) {
		return ((x != 0) && ((x & (~x + 1)) == x));
	}

	public static int log2(final int x) {
		return (int) (Math.log(x) / Math.log(2));
	}

	public int[] createTargetArray(final int[] nums, final int[] index) {
		final List<Integer> l = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			l.add(index[i], nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = l.get(i);
		}
		return nums;
	}

	public int sumFourDivisors(final int[] nums) {
		final Map<Integer, Integer> memo = new HashMap<>();
		int sum = 0;
		for (final int i : nums) {
			sum += numberOfDivisors(memo, i);
		}
		return sum;
	}

	public static int numberOfDivisors(final Map<Integer, Integer> memo, final int n) {
		int count = 0, sum = 0, res = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i) {
					sum += i;
					count++;
				} else {
					sum += i + (n / i);
					count += 2;
				}
				if (count > 4) {
					res = 0;
					break;
				}
			}
		}
		if (count == 4) {
			res = sum;
		}
		memo.put(n, res);
		return res;
	}

}
