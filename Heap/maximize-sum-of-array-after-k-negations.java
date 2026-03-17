//Problem: https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/description/





import java.io.*;
import java.util.*;


class MaximizeSum {
    public int kNegations(int[] nums, int k) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
        }

        while(k!=0) {
            int top = pq.poll();
            pq.add(top*-1);
            k--;
        }

        while(!pq.isEmpty()) {
            sum+=pq.poll();
        }
        return sum;
    }
}


class Main {
    public static void main(String[] args) {
        MaximizeSum arr = new MaximizeSum();
        int[] nums = {4,2,3};
        System.out.println(arr.kNegations(nums, 1));
        
        int[] nums1 = {3,-1,0,2};
        System.out.println(arr.kNegations(nums1, 3));
        
        int[] nums2 = {2,-3,-1,5,-4};
        System.out.println(arr.kNegations(nums2, 2));
    }
}