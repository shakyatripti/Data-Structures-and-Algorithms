//Problem: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/




import java.io.*;
import java.util.*;


class SequentialPrefixSum {
    public int missingInteger(int[] nums) {
        int n=nums.length, len=0, sum=nums[0], flag=0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for(int i=1; i<n; i++) {
            arr.add(nums[i]);
            if(nums[i]-nums[i-1]==1 && flag==0) {
                sum+=nums[i];
            } else {
                flag = 1;
            }
        }

        while(arr.contains(sum)){
            sum++;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        SequentialPrefixSum prefix = new SequentialPrefixSum();
        int[] nums = {1,2,3,2,5};
        System.out.println(prefix.missingInteger(nums));
        
        int[] nums1 = {3,4,5,1,12,14,13};
        System.out.println(prefix.missingInteger(nums1));
        
        int[] nums2 = {29,30,31,32,33,34,35,36,37};
        System.out.println(prefix.missingInteger(nums2));
    }
}