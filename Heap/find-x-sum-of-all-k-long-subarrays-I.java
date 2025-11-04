//Problem: https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/




import java.io.*;
import java.util.*;

class KLongSubarraysI {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] ans = new int[n-k+1];
        for(int i=0; i<n-k+1; i++) {
            int[] freq = new int[51];
            int sum=0, t=x;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (b[1] == a[1]) {
                    return Integer.compare(b[0], a[0]);
                }
                return Integer.compare(b[1], a[1]);
            });
            for(int j=i; j<i+k; j++) {
                freq[nums[j]]++;
            }
            for(int m=0; m<51; m++) {
                if(freq[m]!=0) {
                    pq.add(new int[]{m, freq[m]});
                }
            }

            while(t!=0 && !pq.isEmpty()) {
                int[] pair  = pq.poll();
                sum+=pair[0]*pair[1];
                t--;
            }
            ans[i] = sum;
        }
        return ans;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}


class Main {
    public static void main(String[] args) {
        KLongSubarraysI subarray = new KLongSubarraysI();
        int[] nums = {1,1,2,2,3,4,2,3};
        int[] ans = subarray.findXSum(nums, 6, 2);
        subarray.display(ans);
        
        int[] nums1 = {3,8,7,8,7,5};
        int[] ans1 = subarray.findXSum(nums1, 2, 2);
        subarray.display(ans1);
        
        int[] nums2 = {9,2,2};
        int[] ans2 = subarray.findXSum(nums2, 3, 3);
        subarray.display(ans2);
        
        int[] nums3 = {6,5,1,2,2,3,4,2,3,5};
        int[] ans3 = subarray.findXSum(nums3, 2, 1);
        subarray.display(ans3);
    }
}

