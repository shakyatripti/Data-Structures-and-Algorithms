//Problem: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/


//Brute Force Solution
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



//Optimal Solution
import java.io.*;
import java.util.*;

class MinRecolors {
    public int minRecolorsToGetBlack(String blocks, int k) {
        int whites = Integer.MAX_VALUE, countWhites = 0;
        for(int i=0; i<k; i++) {
            if(blocks.charAt(i)=='W') {
                countWhites++;
            }
        }
        whites = countWhites;
        for(int i=k; i<blocks.length(); i++) {
            if(blocks.charAt(i-k)=='W') {
                countWhites--;
            }
            if(blocks.charAt(i)=='W') {
                countWhites++;
            }
            whites = Math.min(whites, countWhites);
        }
        return whites;
    }
}

class Main {
    public static void main(String[] args) {
        MinRecolors colors = new MinRecolors();
        System.out.println(colors.minRecolorsToGetBlack("WBBWWBBWBW", 7));
        System.out.println(colors.minRecolorsToGetBlack("WBWBBBW", 2));
        System.out.println(colors.minRecolorsToGetBlack("WBWWWWWBBB", 4));
    }
}