package dsa.leetcode.medium.string;

/*
  Palindromic Substrings


Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 */
public class PalindromicSubStrings {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += expandIfPalindrome(s, i, i);
            res += expandIfPalindrome(s, i, i + 1);
        }
        return res;
    }

    private int expandIfPalindrome(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--; j++; count++;
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubStrings ps = new PalindromicSubStrings();
        System.out.println(ps.countSubstrings("bbbbb"));
    }
}
