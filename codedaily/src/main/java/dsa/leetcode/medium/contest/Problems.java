package dsa.leetcode.medium.contest;

import java.util.*;

public class Problems {
    public static void main(String[] args) {
        Problems p = new Problems();
        System.out.println(p.minStartValue(new int[] { -3, 2, -3, 4, 2 }));
        System.out.println(p.findMinFibonacciNumbers(19));
        System.out.println(p.getHappyString(10, 100));
    }

    public int minStartValue(int[] nums) {
        int min = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
        }
        if (min > 0)
            return min;
        return Math.abs(min) + 1;
    }

    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibSeries = new ArrayList<>();
        int count = 0;
        generateAllFibonacciNums(k, fibSeries);
        while (k != 0) {
            for (int i = fibSeries.size() - 1; i >= 0; i--) {
                if (fibSeries.get(i) <= k) {
                    k -= fibSeries.get(i);
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        Map<Character, List<Character>> map = new LinkedHashMap<>();
        map.put('a', Arrays.asList('b', 'c'));
        map.put('b', Arrays.asList('a', 'c'));
        map.put('c', Arrays.asList('a', 'b'));
        for (Character a : map.keySet()) {
            permute(result, map, n, a + "", a);
        }
        System.out.println(result.size());
        if (result.size() < k)
            return "";
        return result.get(k - 1);
    }

    private void permute(List<String> result, Map<Character, List<Character>> map, int n, String s, Character curr) {
        if (s.length() == n) {
            result.add(s);
            return;
        }
        for (Character a : map.get(curr)) {
            permute(result, map, n, s + a, a);
        }
    }

    public void generateAllFibonacciNums(int k, List<Integer> fibSeries) {
        fibSeries.add(1);
        fibSeries.add(1);
        int n = 1, i = 2;
        while (n <= k) {
            n = fibSeries.get(i - 1) + fibSeries.get(i - 2);
            fibSeries.add(n);
            i++;
        }
    }
}