//Problem: https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-ii/description/





import java.io.*;
import java.util.*;


class EquallySpacedOccurrencesII {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            if(mp.containsKey(nums[i])) {
                ArrayList<Integer> arr = mp.get(nums[i]);
                arr.add(i);
                mp.put(nums[i], arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                mp.put(nums[i], arr);
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> it: mp.entrySet()) {
            ArrayList<Integer> arr = it.getValue();
            if(isSpecial(arr)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isSpecial(ArrayList<Integer> arr) {
        if(arr.size() < 3) {
            return false;
        }

        int diff = arr.get(1) - arr.get(0);
        for(int i=1; i<arr.size(); i++) {
            if(arr.get(i) - arr.get(i-1)!=diff) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        EquallySpacedOccurrencesII arr = new EquallySpacedOccurrencesII();
        int[] nums = {1,8,1,5,1,5,8,5};
        System.out.println(arr.countSpecialIntegers(nums));
        
        int[] nums1 = {8,8,8,8};
        System.out.println(arr.countSpecialIntegers(nums1));
        
        int[] nums2 = {8,6,6,8,8};
        System.out.println(arr.countSpecialIntegers(nums2));
    }
}