//Problem: https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/





// Brute Force Solution

import java.io.*;
import java.util.*;


class FindResultantArray {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int l=0, r=0;
        List<String> res = new ArrayList<>();
        for(int i=1; i<words.length; i++) {
            int flag = 0;
            int[] freq = new int[26];
            int[] freq1 = new int[26];
            frequency(words[i], freq);
            frequency(words[i-1], freq1);
            for(int j=0; j<26; j++) {
                if(freq[j]!=freq1[j]) {
                    flag=1;
                    break;
                }
            }
            if(flag==0) {
                ans.add(words[i]);
            }
        }
        while(l < words.length && r < ans.size()) {
            if(words[l]!=ans.get(r)) {
                res.add(words[l]);
            } else {
                r++;
            }
            l++;
        }
        while(l < words.length) {
            res.add(words[l]);
            l++;
        }
        return res;
    }

    public void frequency(String word, int[] freq) {
        for(int i=0; i<word.length(); i++) {
            freq[word.charAt(i)-'a']++;
        }
    }
    
    public void display(List<String> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        FindResultantArray arr = new FindResultantArray();
        String[] words = {"abba","baba","bbaa","cd","cd"};
        List<String> ans = arr.removeAnagrams(words);
        arr.display(ans);
        
        String[] words1 = {"a","b","c","d","e"};
        List<String> ans1 = arr.removeAnagrams(words1);
        arr.display(ans1);
        
        String[] words2 = {"z","z","z","gsw","wsg","gsw","krptu"};
        List<String> ans2 = arr.removeAnagrams(words2);
        arr.display(ans2);
    }
}





// Better Solution

import java.io.*;
import java.util.*;


class FindResultantArray {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String prev = "";
        for(int i=0; i<words.length; i++) {
            String curr = sorted(words[i]);
            if(!curr.equals(prev)) {
                prev = curr;
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public String sorted(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
    
    public void display(List<String> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        FindResultantArray arr = new FindResultantArray();
        String[] words = {"abba","baba","bbaa","cd","cd"};
        List<String> ans = arr.removeAnagrams(words);
        arr.display(ans);
        
        String[] words1 = {"a","b","c","d","e"};
        List<String> ans1 = arr.removeAnagrams(words1);
        arr.display(ans1);
        
        String[] words2 = {"z","z","z","gsw","wsg","gsw","krptu"};
        List<String> ans2 = arr.removeAnagrams(words2);
        arr.display(ans2);
    }
}