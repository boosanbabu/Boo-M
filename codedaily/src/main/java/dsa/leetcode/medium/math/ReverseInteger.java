package dsa.leetcode.medium.math;

/*
https://leetcode.com/problems/reverse-integer/*/
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            final int rem = x % 10;
            final int newResult = result * 10 + rem;
            final int checkResult = (newResult - rem) / 10;
            if (checkResult != result) return 0;
            result = newResult;
            x = x / 10;
        }
        return result;
    }

}