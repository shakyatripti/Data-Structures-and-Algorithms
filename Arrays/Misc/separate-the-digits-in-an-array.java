//Problem: https://leetcode.com/problems/separate-the-digits-in-an-array/description/




import java.io.*;
import java.util.*;

class SeparateDigits {
    public int[] separated(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            String val = String.valueOf(nums[i]);
            for(char ch: val.toCharArray()) {
                ans.add(ch-'0');
            }
        }
        int[] res = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
    
    public void display(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        SeparateDigits digits = new SeparateDigits();
        int[] nums = {13,25,83,77};
        int[] ans = digits.separated(nums);
        digits.display(ans);
        
        int[] nums1 = {7,1,3,9};
        int[] ans1 = digits.separated(nums1);
        digits.display(ans1);
    }
}