//Problem: https://leetcode.com/problems/min-max-game/description/




import java.io.*;
import java.util.*;

class MinMaxGame {
    public int findMinMax(int[] nums) {
        int[] arr = new int[nums.length/2];
        while(nums.length > 1) {
            int index = 0;
            for(int i=0; i<nums.length/2; i++) {
                if(i%2==0) {
                    arr[index] = Math.min(nums[2*i], nums[2*i+1]);
                } else {
                    arr[index] = Math.max(nums[2*i], nums[2*i+1]);
                }
                index++;
            }
            nums = arr;
            arr = new int[nums.length/2];
        }
        return nums[0];
    }
}

class Main {
    public static void main(String[] args) {
        MinMaxGame game = new MinMaxGame();
        int[] nums = {1,3,5,2,4,8,2,2};
        System.out.println(game.findMinMax(nums));
        
        int[] nums1 = {3};
        System.out.println(game.findMinMax(nums1));
        
        int[] nums2 = {93,40};
        System.out.println(game.findMinMax(nums2));
        
        int[] nums3 = {70,38,21,22};
        System.out.println(game.findMinMax(nums3));
    }
}