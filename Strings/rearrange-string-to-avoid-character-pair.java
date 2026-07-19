//Problem:https://leetcode.com/problems/rearrange-string-to-avoid-character-pair/description



import java.io.*;
import java.util.*;


class NoCharacterPair {
    public String rearrangeString(String s, char x, char y) {
        String ans = "";
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i)-'a']++;
        }

        while(freq[y-'a']!=0) {
            ans+=y;
            freq[y-'a']--;
        }

        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                while(freq[i]!=0) {
                    ans+=(char) (i + 'a');
                    freq[i]--;
                }
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        NoCharacterPair pair = new NoCharacterPair();
        System.out.println(pair.rearrangeString("axe", 'o', 'x'));
        System.out.println(pair.rearrangeString("dcab", 'd', 'b'));
        System.out.println(pair.rearrangeString("aabc", 'a', 'c'));
    }
}