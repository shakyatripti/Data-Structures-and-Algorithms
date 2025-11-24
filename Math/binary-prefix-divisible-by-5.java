//Problem: https://leetcode.com/problems/binary-prefix-divisible-by-5/description/





import java.io.*;
import java.util.*;

class BinaryPrefix {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int val = 0;
        for(int n: nums) {
            val = ((val*2) + n)%5;
            if(val==0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
    
    public void display(List<Boolean> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        BinaryPrefix arr = new BinaryPrefix();
        int[] nums = {0,1,1};
        List<Boolean> ans = arr.prefixesDivBy5(nums);
        arr.display(ans);
        
        int[] nums1 = {1,1,1};
        List<Boolean> ans1 = arr.prefixesDivBy5(nums1);
        arr.display(ans1);
    }
}