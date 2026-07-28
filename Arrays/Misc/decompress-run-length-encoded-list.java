//Problem: https://leetcode.com/problems/decompress-run-length-encoded-list/description/




import java.io.*;
import java.util.*;


class EncodedList {
    public int[] decompress(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<nums.length/2; i++) {
            int freq = nums[2*i];
            int val = nums[2*i+1];
            while(freq!=0) {
                arr.add(val);
                freq--;
            }
        }

        int[] ans = new int[arr.size()];
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
        EncodedList list = new EncodedList();
        int[] nums = {1,2,3,4};
        int[] ans = list.decompress(nums);
        list.display(ans);
        
        int[] nums1 = {1,1,2,3};
        int[] ans1 = list.decompress(nums1);
        list.display(ans1);
    }
}