package dsa.leetcode.medium.greedy;

import java.util.*;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int sum = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            sum += costs[i][0] + costs[costs.length - 1 - i][1];
        }
        return sum;
    }

    public static void main(String[] args) {
        TwoCityScheduling tw = new TwoCityScheduling();
        int[][] costs = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
        tw.twoCitySchedCost(costs);
    }

}