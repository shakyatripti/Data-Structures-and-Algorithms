//Problem: https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/description/



import java.io.*;
import java.util.*;



class LonelyNumbers {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        for(int i=0; i<nums.length; i++) {
            if(mp.get(nums[i])==1 && !mp.containsKey(nums[i]-1) && !mp.containsKey(nums[i]+1)) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    
    public void display(List<Integer> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        LonelyNumbers arr = new LonelyNumbers();
        int[] nums = {10,6,5,8};
        List<Integer> ans = arr.findLonely(nums);
        arr.display(ans);
        
        int[] nums1 = {1,3,5,3};
        List<Integer> ans1 = arr.findLonely(nums1);
        arr.display(ans1);
    }
}