//Problem: https://leetcode.com/problems/reverse-words-with-same-vowel-count/description/





import java.io.*;
import java.util.*;

class SameVowelCount {
    public String reverseWords(String s) {
        String[] words = s.split("\\ ");
        int count = 0;
        if(words.length==1) {
            return words[0];
        }
        StringBuilder ans = new StringBuilder(words[0] + " ");
        for(int i=0; i<words[0].length(); i++) {
            char ch = words[0].charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
               count++;
            }
        }

        for(int i=1; i<words.length; i++) {
            int vowel = 0;
            for(int j=0; j<words[i].length(); j++) {
                char ch = words[i].charAt(j);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                    vowel++;
                }
            }

            StringBuilder str = new StringBuilder(words[i]);
            if(vowel==count) {
                ans.append(str.reverse());
            } else {
                ans.append(str);
            }

            if(i < words.length-1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}


class Main {
    public static void main(String[] args) {
        SameVowelCount str = new SameVowelCount();
        System.out.println(str.reverseWords("cat and mice"));
        System.out.println(str.reverseWords("book is nice"));
        System.out.println(str.reverseWords("banana healthy"));
        System.out.println(str.reverseWords("tea"));
    }
}