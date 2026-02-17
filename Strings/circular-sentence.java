//Problem: https://leetcode.com/problems/circular-sentence/description/




import java.io.*;
import java.util.*;

class CircularSentence {
    public boolean isCircular(String sentence) {
        String[] words = sentence.split("\\ ");
        int n=words.length, m=words[n-1].length();
        if(words[0].charAt(0)!=words[n-1].charAt(m-1)) {
            return false;
        }
        for(int i=0; i<n-1; i++) {
            int len = words[i].length()-1;
            char curr = words[i].charAt(len);
            char next = words[i+1].charAt(0);
            if(curr!=next) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        CircularSentence str = new CircularSentence();
        System.out.println(str.isCircular("leetcode exercises sound delightful"));
        System.out.println(str.isCircular("eetcode"));
        System.out.println(str.isCircular("Leetcode is cool"));
    }
}