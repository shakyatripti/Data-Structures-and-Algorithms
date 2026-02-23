//Problem: https://leetcode.com/problems/find-the-score-difference-in-a-game/description/



import java.io.*;
import java.util.*;

class TwoPlayerGame {
    public int scoreDifference(int[] nums) {
        int first=0, second=0, flag=0;
        for(int i=0; i<nums.length; i++) {
            if((i + 1) % 6==0) {
                flag = 1 - flag;
            }
            if(nums[i]%2!=0) {
                flag = 1 - flag;
            }
            if(flag==0) {
                first+=nums[i];
            }
            if(flag==1) {
                second+=nums[i];
            }
        }
        return first-second;
    }
}

class Main {
    public static void main(String[] args) {
        TwoPlayerGame game = new TwoPlayerGame();
        int[] nums = {1,2,3};
        System.out.println(game.scoreDifference(nums));
        
        int[] nums1 = {2,4,2,1,2,1};
        System.out.println(game.scoreDifference(nums1));
        
        int[] nums2 = {1};
        System.out.println(game.scoreDifference(nums2));
    }
}