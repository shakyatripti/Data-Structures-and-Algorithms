//Problem: https://leetcode.com/problems/count-subarrays-with-majority-element-i/description/





import java.io.*;
import java.util.*;

class MajorityElementI {
    public int countSubarrays(int[] nums, int target) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            HashMap<Integer, Integer> mp = new HashMap<>();
            for(int j=i; j<nums.length; j++) {
                mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
                int val = (int) mp.getOrDefault(target, 0);
                if(val > (j-i+1)/2) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        MajorityElementI element = new MajorityElementI();
        int[] nums = {1,2,2,3};
        System.out.println(element.countSubarrays(nums, 2));
        
        int[] nums1 = {1,1,1,1};
        System.out.println(element.countSubarrays(nums1, 1));
        
        int[] nums2 = {1,2,3};
        System.out.println(element.countSubarrays(nums2, 4));
        
        int[] nums3 = {153339791,733310767,651317539,762835368,553024592,626786186,802532105,293860511,910320721,
        175091493,486471834,175988187,765761971,682194838};
        System.out.println(element.countSubarrays(nums3, 435230887));
    }
}