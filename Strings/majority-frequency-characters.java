//Problem: https://leetcode.com/problems/majority-frequency-characters/description/



import java.io.*;
import java.util.*;

class MajorityFrequency {
    public String findGroup(String s) {
        String ans = "";
        int maxGroup = 0;
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }
        HashMap<Integer, String> mp = new HashMap<>();
        for(int i=0; i<26; i++) {
            char ch = (char) ('a' + i);
            if(freq[i] > 0) {
                if(mp.containsKey(freq[i])) {
                    mp.put(freq[i], mp.get(freq[i]) + ch);
                } else {
                    String str = "";
                    mp.put(freq[i], str+ch);
                }
            }
        }

        for(Map.Entry<Integer, String> it: mp.entrySet()) {
            String str = it.getValue();
            if(maxGroup==str.length()) {
                int val = 0, val1 = 0;
                for(char ch: str.toCharArray()) {
                    val+=freq[ch-'a']++;
                }
                for(char ch: ans.toCharArray()) {
                    val1+=freq[ch-'a']++;
                }
                if(val >= val1) {
                    ans = str;
                }
            }
            if(maxGroup < str.length()) {
                maxGroup = str.length();
                ans = str;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        MajorityFrequency str = new MajorityFrequency();
        System.out.println(str.findGroup("aaabbbccdddde"));
        System.out.println(str.findGroup("abcd"));
        System.out.println(str.findGroup("pfpfgi"));
        System.out.println(str.findGroup("fefizfrdnmaepqboddzdreubkdrdylnkmsivavidjdtqxkslsq"));
    }
}