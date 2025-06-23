//Problem: https://leetcode.com/problems/create-target-array-in-the-given-order/description/




import java.io.*;
import java.util.*;

class CreateTargetArray {
    public int[] create(int[] nums, int[] index) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<index.length; i++) {
            arr.add(index[i], nums[i]);
        }
        int[] ans = new int[nums.length];
        for(int i=0; i<arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
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
        CreateTargetArray target = new CreateTargetArray();
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        int[] ans = target.create(nums, index);
        target.display(ans);
        
        int[] nums1 = {1,2,3,4,0};
        int[] index1 = {0,1,2,3,0};
        int[] ans1 = target.create(nums1, index1);
        target.display(ans1);
        
        int[] nums2 = {1};
        int[] index2 = {0};
        int[] ans2 = target.create(nums2, index2);
        target.display(ans2);
    }
}