//Problem: https://leetcode.com/problems/maximum-number-of-words-you-can-type/description




import java.io.*;
import java.util.*;

class WordsYouCanType {
    public int canBeTyped(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<Character>();
        for(char ch: brokenLetters.toCharArray()) {
            broken.add(ch);
        }
        int flag=0, ans=0;
        for(char ch: text.toCharArray()) {
            if(broken.contains(ch)) {
                flag=1;
            }
            if(ch==' ') {
                if(flag==0) {
                    ans++;
                }
                flag=0;
            }
        }
        if(flag==0) {
            ans++;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        WordsYouCanType words = new WordsYouCanType();
        System.out.println(words.canBeTyped("hello world", "ad"));
        System.out.println(words.canBeTyped("leet code", "lt"));
        System.out.println(words.canBeTyped("leet code", "e"));
    }
}