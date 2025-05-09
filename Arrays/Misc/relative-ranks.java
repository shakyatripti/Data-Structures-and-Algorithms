//Problem: https://leetcode.com/problems/relative-ranks/description/


import java.io.*;
import java.util.*;

class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<score.length; i++) {
            mp.put(score[i], i);
        }

        String[] result = new String[score.length];
        Arrays.sort(score);
        int n=score.length;
        for(int i=n-1; i>=0; i--) {
            int index = mp.get(score[i]);
            if(i==n-1) {
                result[index] = "Gold Medal";
            } else if(i==n-2) {
                result[index] = "Silver Medal";
            } else if(i==n-3) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = Integer.toString(n-i);
            }
        }
        return result;
    }
    
    public void display(String[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        RelativeRanks ranks = new RelativeRanks();
        int[] score = {5,4,3,2,1};
        String[] ans = ranks.findRelativeRanks(score);
        ranks.display(ans);
        
        int[] score1 = {10,3,8,9,4};
        String[] ans1 = ranks.findRelativeRanks(score1);
        ranks.display(ans1);
    }
}