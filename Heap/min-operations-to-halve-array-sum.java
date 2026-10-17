//Problem: https://leetcode.com/problems/minimum-operations-to-halve-array-sum/description/




import java.io.*;
import java.util.*;


class HalveArraySum {
    public int minOperations(int[] nums) {
        double total = 0;
        int ops = 0;
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a,b)-> Double.compare(b,a));
        for(int i=0; i<nums.length; i++) {
            pq.add((double)nums[i]);
            total+=nums[i];
        }

        double halfNum = total/2;
        while(!pq.isEmpty()) {
            double half = pq.poll()/2;
            total-=half;
            ops++;
            if(total <= halfNum) {
                return ops;
            } else {
                pq.add(half);
            }
        }
        return ops;
    }
}

class Main {
    public static void main(String[] args) {
        HalveArraySum arr = new HalveArraySum();
        int[] nums = {5,19,8,1};
        System.out.println(arr.minOperations(nums));
        
        int[] nums1 = {3,8,20};
        System.out.println(arr.minOperations(nums1));
    }
}