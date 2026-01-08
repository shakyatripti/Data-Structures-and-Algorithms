//Problem: https://leetcode.com/problems/apply-operations-to-make-string-empty/description/




import java.io.*;
import java.util.*;

class MakeStringEmpty {
    public String lastString(String s) {
        String ans = "";
        int maxVal = 0;
        int[] freq = new int[26];
        int[] lastOccur = new int[26];
        Arrays.fill(lastOccur, -1);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch-'a']++;
            maxVal = Math.max(freq[ch-'a'], maxVal);
            lastOccur[ch-'a'] = i;
        }

        for(int i=0; i<26; i++) {
            if(lastOccur[i] >= 0 && freq[i]==maxVal) {
                arr.add(lastOccur[i]);
            }
        }
        Collections.sort(arr);

        for(int i=0; i<arr.size(); i++) {
            ans+=s.charAt(arr.get(i));
        }

        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        MakeStringEmpty str = new MakeStringEmpty();
        System.out.println(str.lastString("aabcbbca"));
        System.out.println(str.lastString("abcd"));
    }
}