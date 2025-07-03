//Problem: https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/



import java.io.*;
import java.util.*;

class StringGame {
    public char kthCharacter(int k) {
        int count = 1;
        String ans = "a";
        while(ans.length() < k) {
            for(char ch: ans.toCharArray()) {
                char newChar = (char) (ch + 1);
                count++;
                if(count==k) {
                    return newChar;
                }
                ans+=newChar;
            }
        }
        return 'a';
    }
}

class Main {
    public static void main(String[] args) {
        StringGame str = new StringGame();
        System.out.println(str.kthCharacter(5));
        System.out.println(str.kthCharacter(10));
    }
}