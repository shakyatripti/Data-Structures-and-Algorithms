//Problem: https://leetcode.com/problems/last-visited-integers/description/





import java.io.*;
import java.util.*;

class IntegerArray {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k=0, n=nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i]!=-1) {
                k=0;
                seen.add(nums[i]);
            } else {
                int r = seen.size();
                if(k < r) {
                    ans.add(seen.get(r-k-1));
                } else {
                    ans.add(-1);
                }
                k++;
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
        IntegerArray arr = new IntegerArray();
        int[] nums = {1,2,-1,-1,-1};
        List<Integer> ans = arr.lastVisitedIntegers(nums);
        arr.display(ans);
        
        int[] nums1 = {1,-1,2,-1,-1};
        List<Integer> ans1 = arr.lastVisitedIntegers(nums1);
        arr.display(ans1);
    }
}