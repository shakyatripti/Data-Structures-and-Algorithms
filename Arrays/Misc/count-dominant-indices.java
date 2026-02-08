//Problem: https://leetcode.com/problems/count-dominant-indices/description/





import java.io.*;
import java.util.*;

class DominantIndices {
    public int countIndices(int[] nums) {
        int count = 0, n = nums.length;
        for(int i=0; i<n-1; i++) {
            double avg = 0, sum = 0, size = 0;
            for(int j=i+1; j<n; j++) {
                sum+=nums[j];
                size++;
            }
            avg=sum/size;
            if(avg < nums[i]) {
                count++;
            }
        }
        return count;
    }
}


class Main {
    public static void main(String[] args) {
        DominantIndices arr = new DominantIndices();
        int[] nums = {5,4,3};
        System.out.println(arr.countIndices(nums));
        
        int[] nums1 = {4,1,2};
        System.out.println(arr.countIndices(nums1));
    }
}