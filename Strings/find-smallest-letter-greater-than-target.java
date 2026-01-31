//Problem: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/





import java.io.*;
import java.util.*;

class SmallestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int targetVal = target - 'a';
        for(int i=0; i<letters.length; i++) {
            int val = letters[i] - 'a';
            if(val > targetVal) {
                return letters[i];
            }
        }
        return letters[0];
    }
}

class Main {
    public static void main(String[] args) {
        SmallestLetter str = new SmallestLetter();
        char[] letters = {'c','f','j'};
        System.out.println(str.nextGreatestLetter(letters, 'a'));
        
        char[] letters1 = {'c','f','j'};
        System.out.println(str.nextGreatestLetter(letters1, 'c'));
        
        char[] letters2 = {'x','x','y','y'};
        System.out.println(str.nextGreatestLetter(letters2, 'z'));
    }
}