package dsa.leetcode.medium.graph;

import java.util.*;

class Solution {
    public int maxDiff(int num) {
        int n = num;
        if (n < 10)
            return 8;
        List<Integer> actualDigits = new ArrayList<>();
        while (n > 0) {
            actualDigits.add(n % 10);
            n /= 10;
        }

        int i = actualDigits.size() - 1;
        for (int a = actualDigits.size() - 1; a >= 0; a--) {
            if (actualDigits.get(a) != 9)
                break;
            i--;
        }
        System.out.println("digits " + actualDigits.size() + " i " + i);
        int small = 0;
        int big = convertXToY(num, actualDigits.get(i), 9);
        if (i == actualDigits.size() - 1) {
            small = convertXToY(num, actualDigits.get(actualDigits.size() - 2), 0);
            if (small == 0)
                small = convertXToY(num, actualDigits.get(actualDigits.size() - 1), 1);
        } else {
            small = convertXToY(num, actualDigits.get(actualDigits.size() - 1), 1);
        }
        System.out.println("Big " + big);
        System.out.println("Small " + small);
        System.out.println("Result  " + (big - small));
        return big - small;
    }

    static int convertXtoYRec(int num, int x, int y) {
        if (num == 0)
            return 0;

        int digit = num % 10;
        if (digit == x)
            digit = y;

        return convertXtoYRec(num / 10, x, y) * 10 + digit;
    }

    static int convertXToY(int num, int x, int y) {
        if (num == 0)
            return y;
        else
            return convertXtoYRec(num, x, y);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxDiff(555);
        System.out.println(convertXToY(5555, 2, 9));
    }
}