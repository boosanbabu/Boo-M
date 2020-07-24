package dsa.leetcode.medium.array;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int zCount = 0, oCount = 0, result = 0;
        int i=0,j=0;
        for(int n:nums){
            if(n==0){
                zCount++;
            }else{
                oCount++;
            }
        }
        return result;
    }
}