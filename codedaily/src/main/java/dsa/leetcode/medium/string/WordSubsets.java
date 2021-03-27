package dsa.leetcode.medium.string;

import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * 916. Word Subsets
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 *
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 *
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 *
 * Return a list of all universal words in A.  You can return the words in any order.
 */
public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] maxFreqMap = new int[26];
        for(String b:B){
            int[] freqMap = getFreqMap(b);
            for(int i=0;i<26;i++){
                maxFreqMap[i] = Math.max(maxFreqMap[i],freqMap[i]);
            }
        }
        List<String> res = Arrays.stream(A).filter(a->match(maxFreqMap,a)).collect(Collectors.toList());
        return res;
    }

    private boolean match(int[] maxFreqMap , String a) {
        int[] aMap = getFreqMap(a);
        for(int i=0;i<26;i++){
            if(aMap[i]<maxFreqMap[i]) return false;
        }
        return true;
    }

    private int[] getFreqMap(String e) {
        int[] freqMap = new int[26];
        for (char c : e.toCharArray()) {
            freqMap[c-'a']++;
        }
        return freqMap;
    }

    public static void main(String args[]){
        WordSubsets w = new WordSubsets();
        String[] B = {"ec","oc","ceo"};
        String[] A = {"amazon","apple","facebook","google","leetcode"};

        List<String> res = w.wordSubsets(A, B);
        res.stream().forEach(System.out::println);
    }
}
