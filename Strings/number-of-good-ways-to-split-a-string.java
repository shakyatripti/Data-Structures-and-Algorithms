//Problem: https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/





import java.io.*;
import java.util.*;

class GoodWays {
    public int numSplits(String s) {
        int ans = 0;
        int[] leftFreq = new int[26];
        int[] rightFreq = new int[26];
        for(int i=0; i<s.length(); i++) {
            rightFreq[s.charAt(i)-'a']++;
        }

        for(char ch: s.toCharArray()) {
            if(countDistinct(leftFreq)==countDistinct(rightFreq)) {
                ans++;
            }
            leftFreq[ch-'a']++;
            rightFreq[ch-'a']--;
        }
        return ans;
    }

    public int countDistinct(int[] freq) {
        int count = 0;
        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        GoodWays str = new GoodWays();
        System.out.println(str.numSplits("aacaba"));
        System.out.println(str.numSplits("abcd"));
    }
}