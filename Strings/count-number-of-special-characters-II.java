//Problem: https://leetcode.com/problems/count-the-number-of-special-characters-ii/description/




import java.io.*;
import java.util.*;


class SpecialCharsII {
    public int count(String word) {
        int count = 0;
        int[] lower = new int[26];
        int[] upper = new int[26];
        Arrays.fill(upper, -1);
        Arrays.fill(lower, -1);
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int v1 = ch - 'a';
            int v2 = ch - 'A';
            if(v1>=0 && v1<26) {
                lower[v1] = i;
            }
            if(v2>=0 && v2<26 && upper[v2]==-1) {
                upper[v2] = i;
            }
        }

        for(int i=0; i<26; i++) {
            if(lower[i]!=-1 && upper[i]!=-1 && upper[i] > lower[i]) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        SpecialCharsII str = new SpecialCharsII();
        System.out.println(str.count("aaAbcBC"));
        System.out.println(str.count("abc"));
        System.out.println(str.count("AbBCab"));
    }
}