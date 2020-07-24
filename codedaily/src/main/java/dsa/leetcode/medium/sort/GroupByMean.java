package dsa.leetcode.medium.sort;

import java.util.*;

public class GroupByMean {

	List<Integer>[] groupByMean(List<Integer>[] inp) {
		Map<Double, List<Integer>> avgMap = new LinkedHashMap<>();
		for (int i = 0; i < inp.length; i++) {
			if (inp[i] != null && !inp[i].isEmpty()) {
				double sum = 0;
				for (int j : inp[i]) {
					sum += j;
				}
				Double avg = sum / (inp[i].size());
				List<Integer> v = avgMap.getOrDefault(avg, new ArrayList<Integer>());
				v.add(i);
				avgMap.put(avg, v);
			}
		}
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>(avgMap.values());
		return res.toArray(new List[0]);
	}

	public static void main(String[] args) {
		GroupByMean g = new GroupByMean();
		List<Integer>[] inp = new List[3];
		inp[0] = Arrays.asList(new Integer[] { -5, 2, 3 });
		inp[1] = Arrays.asList(new Integer[] { 0, 0 });
		inp[2] = Arrays.asList(new Integer[] { 0 });
		List<Integer>[] res = g.groupByMean(inp);
		for (List<Integer> row : res) {
			for (int i : row) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
