//Problem: https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/






import java.io.*;
import java.util.*;

class CountPrefixAndSuffix {
    public int countPairs(String[] words) {
        int count = 0;
        for(int i=0; i<words.length; i++) {
            String str = words[i];
            int len = str.length();
            for(int j=i+1; j<words.length; j++) {
                int orgLen = words[j].length();
                if(len < orgLen) {
                    String str1 = words[j].substring(0, len);
                    String str2 = words[j].substring(orgLen - len, orgLen);
                    if(str1.equals(str) && str2.equals(str)) {
                      count++;
                    }
                }
                if(str.equals(words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CountPrefixAndSuffix str = new CountPrefixAndSuffix();
        String[] words = {"a","aba","ababa","aa"};
        System.out.println(str.countPairs(words));
        
        String[] words1 = {"pa","papa","ma","mama"};
        System.out.println(str.countPairs(words1));
        
        String[] words2 = {"abab","ab"};
        System.out.println(str.countPairs(words2));
        
        String[] words3 = {"bb", "bb"};
        System.out.println(str.countPairs(words3));
    }
}