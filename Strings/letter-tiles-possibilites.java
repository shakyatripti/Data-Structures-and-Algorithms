//Problem: https://leetcode.com/problems/letter-tile-possibilities/description/

import java.io.*;
import java.util.*;

class LetterTilePossibilities {
    public int letterTiles(String tiles) {
        int[] freq = new int[26];
        for(char ch: tiles.toCharArray()) {
            freq[ch-'A']++;
        }
        return backtrack(freq);
    }
    
    public int backtrack(int[] freq) {
        int count = 0;
        for(int i=0; i<freq.length; i++) {
            if(freq[i] > 0) {
                freq[i]--;
                count+= 1+ backtrack(freq);
                freq[i]++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        LetterTilePossibilities tiles = new LetterTilePossibilities();
        System.out.println(tiles.letterTiles("AAB"));
        System.out.println(tiles.letterTiles("AAABBC"));
    }
}