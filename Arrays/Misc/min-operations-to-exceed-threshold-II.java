//Problem: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/

import java.io.*;
import java.util.*;

class MinOperations {
    public int minOperations(int[] nums, int k) {
        int operations = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < k) {
                pq.add(nums[i]);
            }
        }
        while(!pq.isEmpty()) {
            int firstSmall = pq.poll();
            operations++;
            if(!pq.isEmpty()) {
                int secondSmall = pq.poll();
                long ans = 2L*firstSmall + secondSmall;
                if(ans < k) {
                    pq.add((int) ans);
                }
            }
        }
        return operations;
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = {999999999,999999999,999999999};
        int[] nums1 = {1,1,2,4,9};
        MinOperations arr = new MinOperations();
        System.out.println(arr.minOperations(nums,1000000000));
        System.out.println(arr.minOperations(nums1, 20));
    }
}