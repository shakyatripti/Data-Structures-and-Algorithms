//Problem: https://leetcode.com/problems/check-distances-between-same-letters/description/





import java.io.*;
import java.util.*;

class SameLetters {
    public boolean checkDistances(String s, int[] distance) {
        int[] nums = new int[26];
        Arrays.fill(nums, -1);
        for(int i=s.length()-1; i>=0; i--) {
            int val = s.charAt(i) - 'a';
            if(nums[val]!=-1) {
                nums[val]-=i;
                nums[val]--;
            } else {
                nums[val]=i;
            }
        }
        
        for(int i=0; i<26; i++) {
            if(nums[i]!=-1 && nums[i]!=distance[i]) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        SameLetters letters = new SameLetters();
        int[] distance = {1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(letters.checkDistances("abaccb", distance));
        
        int[] distance1 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(letters.checkDistances("aa", distance1));
    }
}