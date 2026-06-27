//Problem: https://leetcode.com/problems/most-common-word/description/





import java.util.*;
import java.io.*;

class WordInParagraph {
    public String findMostCommon(String paragraph, String[] banned) {
        String ans = "";
        int freq = 0;
        String[] words = paragraph.toLowerCase().split("[\\s!?',;.]+");
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i=0; i<words.length; i++){
            mp.put(words[i], mp.getOrDefault(words[i], 0) + 1);
        }

        for(Map.Entry<String, Integer> it: mp.entrySet()) {
            int val = it.getValue();
            String str = it.getKey();
            boolean hasStr = Arrays.asList(banned).contains(str);
            if(freq <= val && !hasStr) {
                freq = val;
                ans = str;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        WordInParagraph word = new WordInParagraph();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(word.findMostCommon(paragraph, banned));
        
        String paragraph1 = "a.";
        String[] banned1 = {};
        System.out.println(word.findMostCommon(paragraph1, banned1));
        
        String paragraph2 = "a b.b";
        String[] banned2 = {};
        System.out.println(word.findMostCommon(paragraph2, banned2));
    }
}