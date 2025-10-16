//Problem: https://leetcode.com/problems/maximize-sum-of-at-most-k-distinct-elements/description/





import java.io.*;
import java.util.*;

class MaximizeSum {
    public int[] maxKDistinct(int[] nums, int k) {
        ArrayList<Integer> elements = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(!elements.contains(nums[i])) {
               elements.add(nums[i]);
            }
        }
        Collections.sort(elements);
        int index = 0, len = elements.size();
        int size = Math.min(len, k);
        int[] ans = new int[size];
        for(int i=0; i<size; i++) {
            ans[index] = elements.get(len-i-1);
            index++;
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
        MaximizeSum arr = new MaximizeSum();
        int[] nums = {84,93,100,77,90};
        int[] ans = arr.maxKDistinct(nums, 3);
        arr.display(ans);
        
        int[] nums1 = {84,93,100,77,93};
        int[] ans1 = arr.maxKDistinct(nums1, 3);
        arr.display(ans1);
        
        int[] nums2 = {1,1,1,2,2,2};
        int[] ans2 = arr.maxKDistinct(nums2, 6);
        arr.display(ans2);
    }
}