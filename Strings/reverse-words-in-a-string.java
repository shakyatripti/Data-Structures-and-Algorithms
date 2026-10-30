//Problem: https://leetcode.com/problems/reverse-words-in-a-string/description/



import java.io.*;
import java.util.*;


class StringSequence {
    public String reverseWords(String s) {
        String[] words = s.split("\\ ");
        StringBuilder ans = new StringBuilder();
        for(int i=words.length-1; i>=0; i--) {
            if(words[i].length() > 0 && words[i].charAt(0)!=' ') {
                ans.append(words[i]);
                ans.append(" ");
            }
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        StringSequence str = new StringSequence();
        System.out.println(str.reverseWords("the sky is blue"));
        System.out.println(str.reverseWords("  hello world  "));
        System.out.println(str.reverseWords("a good   example"));
    }
}