//Problem: https://leetcode.com/problems/find-missing-elements/description/





import java.io.*;
import java.util.*;


class MissingElements {
    public List<Integer> find(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length, k=0;
        for(int i=nums[0]; i<=nums[n-1]; i++) {
            if(i!=nums[k]) {
                ans.add(i);
            } else {
                k++;
            }
        }
        return ans;
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
        MissingElements arr = new MissingElements();
        int[] nums = {1,4,2,5};
        List<Integer> ans = arr.find(nums);
        arr.display(ans);
        
        int[] nums1 = {7,8,6,9};
        List<Integer> ans1 = arr.find(nums1);
        arr.display(ans1);
        
        int[] nums2 = {5,1};
        List<Integer> ans2 = arr.find(nums2);
        arr.display(ans2);
    }
}