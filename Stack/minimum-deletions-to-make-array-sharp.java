//Problem: https://leetcode.com/problems/minimum-deletions-to-make-array-sharp/description/





import java.io.*;
import java.util.*;


class MakeArraySharp {
    public int minDeletions(int[] nums) {
        int count = 0, k = 0;
        Stack<Integer> st = new Stack<>();
        while(k < nums.length) {
            st.add(nums[k]);
            k++;
            while(k < nums.length && st.peek()==nums[k]) {
                count++;
                k++;
            } 
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        MakeArraySharp arr = new MakeArraySharp();
        int[] nums = {1,1,2,2,2,3};
        System.out.println(arr.minDeletions(nums));
        
        int[] nums1 = {4,4,9,4};
        System.out.println(arr.minDeletions(nums1));
    }
}