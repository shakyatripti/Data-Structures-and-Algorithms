//Problem: https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/





import java.io.*;
import java.util.*;

class MarkAllElements {
    public long findScore(int[] nums) {
        long score = 0;
        int n=nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(b[0]==a[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        for(int i=0; i<n; i++) {
            pq.add(new int[]{nums[i], i});
        }

        while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            int val = pair[0], idx = pair[1];
            if(val==nums[idx]) {
                score+=val;
                if((idx + 1)>=0 && (idx+1)<n) {
                    nums[idx+1] = -1;
                }
                if((idx-1)>=0 && (idx-1)<n) {
                    nums[idx-1] = -1;
                }
            }
        }
        return score;
    }
}

class Main {
    public static void main(String[] args) {
        MarkAllElements arr = new MarkAllElements();
        int[] nums = {2,1,3,4,5,2};
        System.out.println(arr.findScore(nums));
        
        int[] nums1 = {2,3,5,1,3,2};
        System.out.println(arr.findScore(nums1));
    }
}