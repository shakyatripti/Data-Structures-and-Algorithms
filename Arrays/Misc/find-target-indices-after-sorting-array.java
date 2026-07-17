//Problem: https://leetcode.com/problems/find-target-indices-after-sorting-array/description/




import java.io.*;
import java.util.*;


class SortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==target) {
                arr.add(i);
            }
        }
        return arr;
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
        SortingArray arr = new SortingArray();
        int[] nums = {1,2,5,2,3};
        List<Integer> ans = arr.targetIndices(nums, 2);
        arr.display(ans);
        
        int[] nums1 = {1,2,5,2,3};
        List<Integer> ans1 = arr.targetIndices(nums1, 3);
        arr.display(ans1);
        
        int[] nums2 = {1,2,5,2,3};
        List<Integer> ans2 = arr.targetIndices(nums2, 5);
        arr.display(ans2);
    }
}