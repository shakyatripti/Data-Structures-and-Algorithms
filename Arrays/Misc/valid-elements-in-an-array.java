///Problem: https://leetcode.com/problems/valid-elements-in-an-array/description/




import java.io.*;
import java.util.*;


class ValidElements {
    public List<Integer> findValid (int[] nums) {
        int leftVal = 0, n = nums.length;
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1; i<n; i++) {
            leftVal = Math.max(nums[i-1], leftVal);
            int rightVal = 0;
            for(int j=i+1; j<n; j++) {
                rightVal = Math.max(rightVal, nums[j]);
            }
            
            if(leftVal < nums[i] || rightVal < nums[i]) {
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
        ValidElements elements = new ValidElements();
        int[] nums = {1,2,4,2,3,2};
        List<Integer> ans = elements.findValid(nums);
        elements.display(ans);
        
        int[] nums1 = {5,5,5,5};
        List<Integer> ans1 = elements.findValid(nums1);
        elements.display(ans1);
        
        int[] nums2 = {1};
        List<Integer> ans2 = elements.findValid(nums2);
        elements.display(ans2);
    }
}