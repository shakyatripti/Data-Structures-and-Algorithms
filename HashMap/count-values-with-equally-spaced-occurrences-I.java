//Problem: https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-i/description/




import java.io.*;
import java.util.*;


class EquallySpacedOccurrencesI {
    public int countSpecialIntegers(int[] nums) {
        int count = 0;
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!mp.containsKey(nums[i])) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                mp.put(nums[i], arr);
            } else {
                ArrayList<Integer> arr = mp.get(nums[i]);
                arr.add(i);
                mp.put(nums[i], arr);
            }
        }

        for(Map.Entry<Integer, ArrayList<Integer>> it: mp.entrySet()) {
            ArrayList<Integer> arr = it.getValue();
            if(arr.size()==3) {
                int first = arr.get(1) - arr.get(0);
                int second = arr.get(2) - arr.get(1);
                if(first==second) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        EquallySpacedOccurrencesI arr = new EquallySpacedOccurrencesI();
        int[] nums = {1,8,1,5,1,5,8,5};
        System.out.println(arr.countSpecialIntegers(nums));
        
        int[] nums1 = {8,8,8,8};
        System.out.println(arr.countSpecialIntegers(nums1));
        
        int[] nums2 = {8,6,6,8,8};
        System.out.println(arr.countSpecialIntegers(nums2));
    }
}