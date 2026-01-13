//Problem: https://leetcode.com/problems/minimum-operations-to-transform-string/description/




import java.io.*;
import java.util.*;

class TransformString {
    public int minOperations(String s) {
        int ans = 0, prev = 25;
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }
        if(freq[0]==s.length()) {
            return ans;
        }

        for(int i=1; i<25; i++) {
            if(freq[i] > 0) {
                if(prev!=25) {
                    ans+=i-prev;
                }
                prev = i;
            }
        }
        ans+=25-prev + 1;
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        TransformString str = new TransformString();
        System.out.println(str.minOperations("yz"));
        System.out.println(str.minOperations("a"));
        System.out.println(str.minOperations("sn"));
        System.out.println(str.minOperations("z"));
    }
}