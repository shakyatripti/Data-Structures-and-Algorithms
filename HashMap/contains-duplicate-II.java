//Problem: https://leetcode.com/problems/contains-duplicate-ii/description/




import java.io.*;
import java.util.*;

class ContainsDuplicateII {
    public boolean isDuplicate(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                ArrayList<Integer> arr = mp.get(nums[i]);
                arr.add(i);
                mp.put(nums[i], arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(i);
                mp.put(nums[i], arr);
            }
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> it: mp.entrySet()) {
            ArrayList<Integer> arr = it.getValue();
            if(arr.size() > 1) {
                for(int i=0; i<arr.size()-1; i++) {
                    if((arr.get(i+1) - arr.get(i)) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        ContainsDuplicateII array = new ContainsDuplicateII();
        int[] nums = {1,2,3,1};
        System.out.println(array.isDuplicate(nums, 3));
        
        int[] nums1 = {1,0,1,1};
        System.out.println(array.isDuplicate(nums1, 1));
        
        int[] nums2 = {1,2,3,1,2,3};
        System.out.println(array.isDuplicate(nums2, 2));
    }
}