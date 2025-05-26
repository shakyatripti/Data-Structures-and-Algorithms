//Problem: https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/




import java.io.*;
import java.util.*;

class StringPairs {
    public int countMaxPairs(String[] words) {
        int res=0;
        int[][] freq = new int[26][26];
        for(int i=0; i<words.length; i++) {
            int firstIndex = words[i].charAt(0) - 'a';
            int secondIndex = words[i].charAt(1) - 'a';
            if(freq[secondIndex][firstIndex] > 0) {
                res++;
                freq[secondIndex][firstIndex]++;
            } else {
                freq[firstIndex][secondIndex]++;
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        StringPairs pairs = new StringPairs();
        String[] words = {"cd","ac","dc","ca","zz"};
        System.out.println(pairs.countMaxPairs(words));
        
        String[] words1 = {"ab","ab","cc"};
        System.out.println(pairs.countMaxPairs(words1));
        
        String[] words2 = {"aa","ab","aa"};
        System.out.println(pairs.countMaxPairs(words2));
    }
}