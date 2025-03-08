//Problem: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/


import java.io.*;
import java.util.*;

class MinRecolors {
    public int minRecolorsToGetBlack(String blocks, int k) {
        int whites = Integer.MAX_VALUE;
        for(int i=0; i<=blocks.length()-k; i++) {
            int countWhites = 0;
            for(int j=i; j<i+k; j++) {
                if(blocks.charAt(j)=='W') {
                    countWhites++;
                }
            }
            whites = Math.min(countWhites, whites);
        }
        return whites;
    }
}

class Main {
    public static void main(String[] args) {
        MinRecolors colors = new MinRecolors();
        System.out.println(colors.minRecolorsToGetBlack("WBBWWBBWBW", 7));
        System.out.println(colors.minRecolorsToGetBlack("WBWBBBW", 2));
    }
}