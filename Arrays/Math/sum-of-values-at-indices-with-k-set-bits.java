//Problem: https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description



import java.io.*;
import java.util.*;

class SumIndices {
    public int kSetBits(List<Integer> nums, int k) {
        int ans=0;
        for(int i=0; i<nums.size(); i++) {
            if(binary(i, k)) {
                ans+=nums.get(i);
            }
        }
        return ans;
    }

    public boolean binary(int n, int k) {
        int count = 0;
        while(n!=0) {
            int r = n%2;
            if(r==1) {
                count++;
            }
            n=n/2;
        }
        if(count==k) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        SumIndices arr = new SumIndices();
        List<Integer> nums = Arrays.asList(5,10,1,5,2);
        System.out.println(arr.kSetBits(nums,1));
        List<Integer> nums1 = Arrays.asList(4,3,2,1);
        System.out.println(arr.kSetBits(nums1,2));
    }
}