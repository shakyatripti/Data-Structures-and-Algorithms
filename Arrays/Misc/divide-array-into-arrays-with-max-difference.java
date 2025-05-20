//Problem: https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/




import java.io.*;
import java.util.*;

class ArrayWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length, index=0;
        int[][] res = new int[n/3][3];
        for(int i=0; i<=n-3; i+=3) {
            if(nums[i+2]-nums[i] > k) {
                return new int[0][0];
            }
            res[index] = new int[]{nums[i], nums[i+1], nums[i+2]};
            index++;
        }
        return res;
    }
    
    public void display(int[][] result) {
        if(result.length==0) {
            System.out.println("empty");
        }
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1] + " " + result[i][2]);
            System.out.print("\n");
        }
    }
}

class Main {
    public static void main(String[] args) {
        ArrayWithMaxDifference arr = new ArrayWithMaxDifference();
        int[] nums = {1,3,4,8,7,9,3,5,1};
        int[][] ans = arr.divideArray(nums, 2);
        arr.display(ans);
        
        int[] nums1 = {2,4,2,2,5,2};
        int[][] ans1 = arr.divideArray(nums1, 2);
        arr.display(ans1);
    }
}