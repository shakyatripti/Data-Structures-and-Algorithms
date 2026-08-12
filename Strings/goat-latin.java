//Problem: https://leetcode.com/problems/goat-latin/description/



import java.io.*;
import java.util.*;


class GoatLatin {
    public String conversion(String sentence) {
        String[] words = sentence.split("\\ ");
        StringBuilder ans = new StringBuilder("");
        int n=words.length;
        for(int i=0; i<n; i++) {
            StringBuilder str = new StringBuilder("");
            char ch = words[i].toLowerCase().charAt(0);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='u' || ch=='o') {
                str.append(words[i]);
            } else {
                str.append(words[i]);
                str.append(words[i].charAt(0));
                str.deleteCharAt(0);
            }
            str.append("ma");
            for(int j=0; j<=i; j++) {
                str.append("a");
            }
            ans.append(str);
            if(i!=n-1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}


class Main {
    public static void main(String[] args) {
        GoatLatin sentence = new GoatLatin();
        System.out.println(sentence.conversion("I speak Goat Latin"));
        System.out.println(sentence.conversion("The quick brown fox jumped over the lazy dog"));
    }
}