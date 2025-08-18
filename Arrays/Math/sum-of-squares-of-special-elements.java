//Problem: https://leetcode.com/problems/sum-of-squares-of-special-elements/description/




import java.io.*;
import java.util.*;

class SpecialElement {
    public int sumOfSquares(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i=0; i<nums.length; i++) {
            if(n%(i+1)==0) {
                sum+=nums[i]*nums[i];
            }
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        SpecialElement element = new SpecialElement();
        int[] nums = {1,2,3,4};
        System.out.println(element.sumOfSquares(nums));
        
        int[] nums1 = {2,7,1,19,18,3};
        System.out.println(element.sumOfSquares(nums1));
    }
}