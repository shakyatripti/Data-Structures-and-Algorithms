//Problem: https://leetcode.com/problems/intersection-of-multiple-arrays/description/



import java.io.*;
import java.util.*;

class MultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        int n=nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            frequency(nums[i], mp);
        }
        Arrays.sort(nums[0]);
        for(int i=0; i<nums[0].length; i++) {
            if(mp.get(nums[0][i])==n) {
                ans.add(nums[0][i]);
            }
        }
        return ans;
    }
    
    
    public void frequency(int[] nums, HashMap<Integer, Integer> mp) {
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
    }
    
    public void display(List<Integer> ans) {
        if(ans.size()==0) {
            System.out.print("empty");
        }
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}


class Main {
    public static void main(String[] args) {
        MultipleArrays arrays = new MultipleArrays();
        int[][] nums = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
        List<Integer> ans = arrays.intersection(nums);
        arrays.display(ans);
        
        int[][] nums1 = {{1,2,3},{4,5,6}};
        List<Integer> ans1 = arrays.intersection(nums1);
        arrays.display(ans1);
        
        int[][] nums2 = {{7,34,45,10,12,27,13},{27,21,45,10,12,13}};
        List<Integer> ans2 = arrays.intersection(nums2);
        arrays.display(ans2);
    }
}