package dsa.leetcode.medium.array;

public class BirthDate {

	public static void main(String[] args) {
		int[][] range = { { 1900, 1999 }, { 1000, 1926 }, { 1928, 1999 }, { 1988, 2000 } };
//		int[] r = buildTableBrute(range);
//		for (int i = 0; i < r.length; i++)
//			System.out.print(i + " : " + r[i] + "\t");
//		System.out.println();
		int a = buildTableBetter(range);
		System.out.println(a);

	}

	/*
	 * Instead of 1000-2020, Assuming it for 0-10
	 */
	public static int[] buildTableBrute(int[][] range) {
		int[] alive = new int[11];
		for (int row[] : range) {
			for (int i = row[0]; i <= row[1]; i++) {
				alive[i]++;
			}
		}

		return alive;
	}

	public static int buildTableBetter(int[][] range) {
		int[] birthDeathCounter = new int[2020 - 1000 + 1];
		for (int row[] : range) {
			birthDeathCounter[row[0] - 1000]++;
			birthDeathCounter[row[1] - 1000 + 1]--;
		}
		int max = Integer.MIN_VALUE, ans = 1000;
		for (int i = 1; i < birthDeathCounter.length; i++) {
			birthDeathCounter[i] += birthDeathCounter[i - 1];
			if (max < birthDeathCounter[i]) {
				ans = i;
				max = birthDeathCounter[i];
			}
		}
		return ans + 1000;
	}

}
