package dsa.leetcode.medium.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/cinema-seat-allocation
 * 
 * Problem statement as pictorial representation, please refer the link above
 */
public class CinemaSeatAllocation {
	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		Map<Integer, Set<Integer>> reserved = new HashMap<>();
		for (int[] row : reservedSeats) {
			reserved.putIfAbsent(row[0], new HashSet<>());
			Set<Integer> seats = reserved.get(row[0]);
			seats.add(row[1]);
		}
		int res = 0;
		for (int row = 1; row <= n; row++) {
			Set<Integer> seats = reserved.get(row);
			res += familiesInThisRow(seats);
		}
		return res;
	}

	public int familiesInThisRow(Set<Integer> seats) {
		if (seats == null)
			return 2;
		int count = 0;
		if (!seats.contains(2) && !seats.contains(3) && !seats.contains(4) && !seats.contains(5)) {
			seats.addAll(Arrays.asList(2, 3, 4, 5));
			count++;
		}
		if (!seats.contains(6) && !seats.contains(7) && !seats.contains(8) && !seats.contains(9)) {
			seats.addAll(Arrays.asList(6, 7, 8, 9));
			count++;
		}
		if (!seats.contains(4) && !seats.contains(5) && !seats.contains(6) && !seats.contains(7)) {
			seats.addAll(Arrays.asList(6, 7, 8, 9));
			count++;
		}
		return count;
	}

}
