//Problem: https://leetcode.com/problems/minimum-operations-to-collect-elements/description/





import java.io.*;
import java.util.*;

class CollectElements {
    public int minOperations(List<Integer> nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.size(); i++) {
            mp.put(nums.get(i), i);
        }

        while(k > 0) {
            ans = Math.min(mp.get(k), ans);
            k--;
        }
        return nums.size() - ans;
    }
}

class Main {
    public static void main(String[] args) {
        CollectElements elements = new CollectElements();
        List<Integer> nums = new ArrayList<>(Arrays.asList(3,1,5,4,2));
        System.out.println(elements.minOperations(nums, 2));
        
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(3,1,5,4,2));
        System.out.println(elements.minOperations(nums1, 5));
        
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(3,2,5,3,1));
        System.out.println(elements.minOperations(nums2, 3));
    }
}