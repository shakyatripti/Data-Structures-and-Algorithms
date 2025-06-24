//Problem: https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/description/



import java.io.*;
import java.util.*;

class KDistinctIndices {
    public List<Integer> findIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==key) {
                ans.add(i);
            }
        }
        if(ans.size() == nums.length) {
            return ans;
        }
        int n=ans.size();
        for(int i=0; i<n; i++) {
            for(int j=0; j<nums.length; j++) {
                if(j!=ans.get(i) && Math.abs(j-ans.get(i))<=k && !ans.contains(j)) {
                    ans.add(j);
                }
            }
        }
        Collections.sort(ans);
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
        KDistinctIndices arr = new KDistinctIndices();
        int[] nums = {3,4,9,1,3,9,5};
        List<Integer> ans = arr.findIndices(nums, 9, 1);
        arr.display(ans);
        
        int[] nums1 = {2,2,2,2,2};
        List<Integer> ans1 = arr.findIndices(nums1, 2, 2);
        arr.display(ans1);
    }
}