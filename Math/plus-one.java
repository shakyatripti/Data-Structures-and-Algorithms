//Problem: https://leetcode.com/problems/plus-one/description/





import java.io.*;
import java.util.*;

class PlusOne {
    public int[] addOne(int[] digits) {
        int r = digits.length-1;
        while(r!=0) {
            if(digits[r] < 9) {
                digits[r]++;
                return digits;
            }
            digits[r] = 0;
            r--;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
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
        PlusOne num = new PlusOne();
        int[] digits = {1,2,3};
        int[] ans = num.addOne(digits);
        num.display(ans);
        
        int[] digits1 = {4,3,2,1};
        int[] ans1 = num.addOne(digits1);
        num.display(ans1);
        
        int[] digits2 = {9};
        int[] ans2 = num.addOne(digits2);
        num.display(ans2);
    }
}