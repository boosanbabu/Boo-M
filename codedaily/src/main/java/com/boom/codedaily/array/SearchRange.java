package com.boom.codedaily.array;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int f = firstOccOfNum(nums, target, 0, nums.length - 1);
        if(f==-1) return new int[]{-1,-1};
        return new int[]{f,lastOccIdx(nums, target, f, nums.length-1)};
    }

    public int firstOccOfNum(int[] arr, int target, int start, int end) {
        if (start == end) 
            if(arr[start]==target) return start;
            else return -1;
        int mid = start - (start - end) / 2, res = arr[mid];
        if (target <= arr[mid]) res = firstOccOfNum(arr, target, start, mid);
        else res = firstOccOfNum(arr, target, mid + 1, end);
        return res;
    }

    public int lastOccIdx(int[] arr, int target, int start, int end) {
        if (start == end) 
            if(arr[start]==target) return start;
            else return -1;
        int mid = start + (1 + (end - start)) / 2, res = mid;
        if (target >= arr[mid]) res = lastOccIdx(arr, target, mid, end);
        else res = lastOccIdx(arr, target, start, mid - 1);
        return res;
    }

    public static void main(String[] args) {
        SearchRange s = new SearchRange();
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 5 };
        int target = 6;
        System.out.println(s.firstOccOfNum(arr, target, 0, arr.length - 1));
        System.out.println(s.lastOccIdx(arr, target, 0, arr.length - 1));
    }
}