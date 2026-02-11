//Problem: https://leetcode.com/problems/maximum-number-of-balloons/description/




import java.io.*;
import java.util.*;

class Balloons {
    public int maxNumber(String text) {
        String s = "balloon";
        int ans = Integer.MAX_VALUE;
        int[] freq = new int[26];
        int[] freq2 = new int[26];
        for(char ch: text.toCharArray()) {
            freq[ch-'a']++;
        }

        for(char ch: s.toCharArray()) {
            freq2[ch-'a']++;
        }

        for(int i=0; i<26; i++) {
            int count = freq[i];
            int target = freq2[i];
            if(count < target) {
                return 0;
            }
            if(target!=0) {
                ans = Math.min(ans, count/target);
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Balloons balloon = new Balloons();
        System.out.println(balloon.maxNumber("nlaebolko"));
        System.out.println(balloon.maxNumber("loonbalxballpoon"));
        System.out.println(balloon.maxNumber("leetcode"));
        System.out.println(balloon.maxNumber("balon"));
        System.out.println(balloon.maxNumber("lloo"));
    }
}