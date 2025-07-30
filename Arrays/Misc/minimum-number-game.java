//Problem: https://leetcode.com/problems/minimum-number-game/description/





import java.io.*;
import java.util.*;

class NumberGame {
    public int[] minimumNum(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i+=2) {
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
        return nums;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] +  " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        NumberGame game = new NumberGame();
        int[] nums = {5,4,2,3};
        int[] ans = game.minimumNum(nums);
        game.display(ans);
        
        int[] nums1 = {2,5};
        int[] ans1 = game.minimumNum(nums1);
        game.display(ans1);
        
        int[] nums2 = {1,8,2,5,6,3};
        int[] ans2 = game.minimumNum(nums2);
        game.display(ans2);
    }
}