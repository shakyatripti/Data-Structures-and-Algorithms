//Problem: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description




import java.io.*;
import java.util.*;

class MinimumDominoRotation {
    public int minimumRotation(int[] tops, int[] bottoms) {
        int topSwaps = minimumSwaps(tops[0], tops, bottoms);
        if(topSwaps!=-1) {
            return topSwaps;
        }
        int bottomSwaps = minimumSwaps(bottoms[0], tops, bottoms);
        return bottomSwaps;
    }
    
    public int minimumSwaps(int target, int[] tops, int[] bottoms) {
        int topSwap=0, bottomSwap=0;
        for(int i=0; i<tops.length; i++) {
            if(tops[i]!=target && bottoms[i]!=target) {
                return -1;
            } else if(tops[i]!=target) {
                topSwap++;
            } else if(bottoms[i]!=target) {
                bottomSwap++;
            }
        }
        return Math.min(bottomSwap, topSwap);
    }
}

class Main {
    public static void main(String[] args) {
        MinimumDominoRotation arr = new MinimumDominoRotation();
        int[] tops = {3,5,1,2,3};
        int[] bottoms = {3,6,3,3,4};
        System.out.println(arr.minimumRotation(tops, bottoms));
        
        int[] tops1 = {2,1,2,4,2,2};
        int[] bottoms1 = {5,2,6,2,3,2};
        System.out.println(arr.minimumRotation(tops1, bottoms1));
        
        int[] tops2 = {1,1,1,1,1,1,1};
        int[] bottoms2 = {1,1,1,1,1,1,1};
        System.out.println(arr.minimumRotation(tops2, bottoms2));
    }
}




