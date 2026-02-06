//Problem: https://leetcode.com/problems/count-special-quadruplets/description/





import java.io.*;
import java.util.*;

class SpecialQuadruplets {
    public int countQuad(int[] nums) {
        int n=nums.length, count=0;
        for(int a=0; a<n; a++) {
            for(int b=a+1; b<n; b++) {
                for(int c=b+1; c<n; c++) {
                    for(int d=c+1; d<n; d++) {
                        if(nums[a] + nums[b] + nums[c] == nums[d]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        SpecialQuadruplets arr = new SpecialQuadruplets();
        int[] nums = {1,2,3,6};
        System.out.println(arr.countQuad(nums));
        
        int[] nums1 = {3,3,6,4,5};
        System.out.println(arr.countQuad(nums1));
        
        int[] nums2 = {1,1,1,3,5};
        System.out.println(arr.countQuad(nums2));
    }
}