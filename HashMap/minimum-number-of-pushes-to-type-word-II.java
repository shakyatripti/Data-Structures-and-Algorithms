//Problem: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/




import java.io.*;
import java.util.*;


class TypeWordII {
    public int minimumPushes(String word) {
        int num = 1, ans = 0;
        int[] freq = new int[26];
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Integer.compare(freq[b-'a'], freq[a-'a']));
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch-'a']++;
        }

        for(int i=0; i<26; i++) {
            if(freq[i]!=0) {
                char ch = (char) (i + 'a');
                pq.add(ch);
            }
        }

        while(!pq.isEmpty()) {
            int count = 1;
            while(count!=9 && !pq.isEmpty()) {
                char ch = pq.poll();
                ans+=freq[ch-'a'] * num;
                count++;
            }
            num++;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        TypeWordII keypad = new TypeWordII();
        System.out.println(keypad.minimumPushes("abcde"));
        System.out.println(keypad.minimumPushes("xyzxyzxyzxyz"));
        System.out.println(keypad.minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}