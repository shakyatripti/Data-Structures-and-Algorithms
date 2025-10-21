//Problem: https://leetcode.com/problems/smallest-missing-multiple-of-k/description/




import java.util.*;
import java.io.*;

class SmallestMissingMultiple {
    public int missingMultiple(int[] nums, int k) {
        int m=1, flag=0, ans=0;
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            st.add(nums[i]);
        }
        while(flag==0) {
            ans = m*k;
            if(!st.contains(ans)) {
                flag=1;
                break;
            } else {
                m++;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        SmallestMissingMultiple arr = new SmallestMissingMultiple();
        int[] nums = {8,2,3,4,6};
        System.out.println(arr.missingMultiple(nums, 2));
        
        int[] nums1 = {1,4,7,10,15};
        System.out.println(arr.missingMultiple(nums1, 5));
    }
}