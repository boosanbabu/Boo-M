package dsa.leetcode.medium.array;

import java.util.*;

public class PermutationQueries {
    public int[] processQueries(int[] queries, int m) {
        int[] marr = new int[m + 1];
        int[] res = new int[queries.length];
        int r = 0;
        for (int i = 0; i < m; i++) {
            marr[i] = i + 1;
        }
        for (int q : queries) {
            int i = 0;
            for (i = 0; i < m; i++)
                if (marr[i] == q)
                    break;
            marr[0] = q;
            // reshuffle(i,marr);
        }
        return res;
    }

    private void elementsBiggerThan(int q, int[] queries, int k) {
        int i = k - 1, c = 0;
        for (i = k - 1; i >= 0; i--) {
            if (queries[i] == queries[k])
                break;
            if (queries[i] > queries[k])
                c++;
        }
        System.out.println(c);
    }

    public static void main(String[] args) {
        PermutationQueries p = new PermutationQueries();
        int[] queries = new int[] { 7, 5, 5, 8, 3 };
        int[] res = p.processQueries(queries, 8);

        for (int i = 0; i < queries.length; i++) {
            p.elementsBiggerThan(queries[i], queries, i);
        }

    }

}