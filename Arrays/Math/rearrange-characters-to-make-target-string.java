//Problem: https://leetcode.com/problems/rearrange-characters-to-make-target-string/description



import java.io.*;
import java.util.*;

class RearrangeCharacters {
    public int maxCopies(String s, String target) {
        int ans = Integer.MAX_VALUE;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> mp2 = new HashMap<>();
        for(int i=0; i<target.length(); i++) {
            char ch = target.charAt(i);
            mp2.put(ch, mp2.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<target.length(); i++) {
            int count1 = mp.getOrDefault(target.charAt(i), 0);
            int count2 = mp2.get(target.charAt(i));
            if(count2 > count1) {
                return 0;
            }
            ans=Math.min(ans, count1/count2);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        RearrangeCharacters copies = new RearrangeCharacters();
        System.out.println(copies.maxCopies("ilovecodingonleetcode", "code"));
        
        System.out.println(copies.maxCopies("abc", "abcd"));
        
        System.out.println(copies.maxCopies("abbaccaddaeea", "aaaaa"));
        
        System.out.println(copies.maxCopies("codecodecodecode", "codecode"));
    }
}