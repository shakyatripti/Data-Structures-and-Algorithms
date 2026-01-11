//Problem: https://leetcode.com/problems/count-residue-prefixes/description/





import java.io.*;
import java.util.*;

class ResiduePrefixes {
    public int countResidue(String s) {
        int[] freq = new int[26];
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch-'a']++;
            int dis = countDistinct(freq);
            if(dis == (i+1)%3) {
                ans++;
            }
        }
        return ans;
    }

    public int countDistinct(int[] freq) {
        int ans = 0;
        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                ans++;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ResiduePrefixes str = new ResiduePrefixes();
        System.out.println(str.countResidue("abc"));
        System.out.println(str.countResidue("dd"));
        System.out.println(str.countResidue("bob"));
    }
}