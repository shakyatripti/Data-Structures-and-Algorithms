//Problem: https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/description/





import java.io.*;
import java.util.*;

class SortTheArray {
    public int minimumRightShifts(List<Integer> nums) {
        int rounds = 0, n = nums.size();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = nums.get(i);
        }
        while(!isSorted(arr) && rounds < n) {
            rounds++;
            int[] shiftArr = new int[n];
            for(int i=0; i<arr.length; i++) {
                int next = (i + 1) % n;
                shiftArr[next] = arr[i];
            }
            arr = shiftArr;
        }
        return rounds==n ? -1 : rounds;
    }

    public boolean isSorted(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        SortTheArray arr = new SortTheArray();
        List<Integer> nums = new ArrayList<>(Arrays.asList(3,4,5,1,2));
        System.out.println(arr.minimumRightShifts(nums));
        
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(1,3,5));
        System.out.println(arr.minimumRightShifts(nums1));
        
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(2,1,4));
        System.out.println(arr.minimumRightShifts(nums2));
    }
}