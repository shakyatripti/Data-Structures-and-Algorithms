//Problem: https://leetcode.com/problems/maximize-expression-of-three-elements/description/




import java.io.*;
import java.util.*;

class MaximizeExpression {
    public int maximizeOfThree(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length-1;
        return nums[n] + nums[n-1] - nums[0];
    }
}

class Main {
    public static void main(String[] args) {
        MaximizeExpression arr = new MaximizeExpression();
        int[] nums = {1,4,2,5};
        System.out.println(arr.maximizeOfThree(nums));
        
        int[] nums1 = {-2,0,5,-2,4};
        System.out.println(arr.maximizeOfThree(nums1));
    }
}