//Problem: https://leetcode.com/problems/slowest-key/description/




import java.io.*;
import java.util.*;

class SlowestKeyPressed {
    public char findKey(int[] releaseTimes, String keysPressed) {
        char ans = 'a';
        long val = 0, prev = 0, n = releaseTimes.length;
        long[] timeTaken = new long[26];
        for(int i=0; i<n; i++) {
            char ch = keysPressed.charAt(i);
            timeTaken[ch-'a']=Math.max((releaseTimes[i] - prev), timeTaken[ch-'a']);
            prev = releaseTimes[i];
        }

        for(int i=0; i<26; i++) {
            if(val <= timeTaken[i]) {
                val = timeTaken[i];
                ans = (char) (i + 'a');
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        SlowestKeyPressed letter = new SlowestKeyPressed(); 
        int[] releaseTimes = {9,29,49,50};
        System.out.println(letter.findKey(releaseTimes, "cbcd"));
        
        int[] releaseTimes1 = {12,23,36,46,62};
        System.out.println(letter.findKey(releaseTimes1, "spuda"));;
    }
}