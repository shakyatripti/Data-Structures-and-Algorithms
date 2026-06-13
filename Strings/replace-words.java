//Problem: https://leetcode.com/problems/replace-words/description/





import java.io.*;
import java.util.*;

class ReplaceWords {
    public String replacement(List<String> dictionary, String sentence) {
        String ans = "";
        Set<String> dict = new HashSet<>(dictionary);
        String[] s = sentence.split("\\ ");
        for(int i=0; i<s.length; i++) {
            StringBuilder str = new StringBuilder();
            int flag = 0;
            for(int j=0; j<s[i].length(); j++) {
                str.append(s[i].charAt(j));
                if(dict.contains(str.toString())) {
                    flag = 1;
                    break;
                }
            }
            
            ans+=str;
            if(i < s.length-1) {
                ans+=" ";
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ReplaceWords words = new ReplaceWords();
        List<String> dictionary = new ArrayList<>(Arrays.asList("cat","bat","rat"));
        String sentence = "the cattle was rattled by the battery";
        System.out.println(words.replacement(dictionary, sentence));
        
        List<String> dictionary1 = new ArrayList<>(Arrays.asList("a","b","c"));
        String sentence1 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(words.replacement(dictionary1, sentence1));
    }
}