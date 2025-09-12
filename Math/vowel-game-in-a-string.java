//Problem: https://leetcode.com/problems/vowels-game-in-a-string/description/




import java.io.*;
import java.util.*;

class VowelsGame {
    public boolean doesAliceWin(String s) {
        int vowels = 0;
        for(char ch: s.toCharArray()) {
            if(ch=='a' || ch=='e' || ch=='u' || ch=='i' || ch=='o') {
                vowels++;
            }
        }
        if(vowels==0) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        VowelsGame game = new VowelsGame();
        System.out.println(game.doesAliceWin("leetcoder"));
        System.out.println(game.doesAliceWin("bbcd"));
        System.out.println(game.doesAliceWin("ifgp"));
    }
}