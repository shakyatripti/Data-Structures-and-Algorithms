//Problem: https://leetcode.com/problems/find-if-digit-game-can-be-won/description/




import java.io.*;
import java.util.*;

class DigitGame {
    public boolean canAliceWin(int[] nums) {
        int singleSum = 0, doubleSum = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= 0 && nums[i] <= 9) {
                singleSum+=nums[i];
            } else {
                doubleSum+=nums[i];
            }
        }
        if(singleSum!=doubleSum) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        DigitGame game = new DigitGame();
        int[] nums = {1,2,3,4,10};
        System.out.println(game.canAliceWin(nums));
        
        int[] nums1 = {1,2,3,4,5,14};
        System.out.println(game.canAliceWin(nums1));
        
        int[] nums2 = {5,5,5,25};
        System.out.println(game.canAliceWin(nums2));
    }
}