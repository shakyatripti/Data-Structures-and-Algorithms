//Problem: https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/description/



import java.io.*;
import java.util.*;

class MinDeletionsForKDistinct {
    public int minimumDeletions(String s, int k) {
        int deletions = 0;
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            freq[ch]++;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int f: freq) {
            if(f > 0) {
                arr.add(f);
            }
        }
        Collections.sort(arr);
        for(int i=0; i<arr.size()-k; i++) {
            deletions+=arr.get(i);
        }
        return deletions;
    }
}

class Main {
    public static void main(String[] args) {
        MinDeletionsForKDistinct obj = new MinDeletionsForKDistinct();
        System.out.println(obj.minimumDeletions("abc", 2));
        System.out.println(obj.minimumDeletions("aabb", 2));
        System.out.println(obj.minimumDeletions("yyyyzz", 1));
        System.out.println(obj.minimumDeletions("msntoonmkut", 3));
    }
}