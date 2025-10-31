//Problem: https://leetcode.com/problems/replace-elements-in-an-array/description/





import java.io.*;
import java.util.*;

class ReplaceElements {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], i);
        }
        for(int i=0; i<operations.length; i++) {
            int key = operations[i][0];
            int val = operations[i][1];
            if(mp.containsKey(key)) {
                mp.put(val, mp.get(key));
                mp.remove(key);
            }
        }

        for(Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            int key = entry.getValue();
            int val = entry.getKey();
            nums[key] = val;
        }
        return nums;
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
        ReplaceElements arr = new ReplaceElements();
        int[] nums = {1,2,4,6};
        int[][] operations = {{1,3},{4,7},{6,1}};
        int[] ans = arr.arrayChange(nums, operations);
        arr.display(ans);
        
        int[] nums1 = {1,2};
        int[][] operations1 = {{1,3},{2,1},{3,2}};
        int[] ans1 = arr.arrayChange(nums1, operations1);
        arr.display(ans1);
    }
}