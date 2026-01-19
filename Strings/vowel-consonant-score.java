//Problem: https://leetcode.com/problems/vowel-consonant-score/description/






import java.io.*;
import java.util.*;

class VowelConsonant {
    public int findScore(String s) {
        int consonant = 0, vowel = 0;
        for(char ch: s.toCharArray()) {
            int r = ch - 'a';
            if(r >= 0 && r<=25) {
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                    vowel++;
                } else {
                    consonant++;
                }
            }
        }
        if(consonant > 0) {
            return (int) Math.floor(vowel/consonant);
        }
        return 0;
    }
}


class Main {
    public static void main(String[] args) {
        VowelConsonant str = new VowelConsonant();
        System.out.println(str.findScore("cooear"));
        System.out.println(str.findScore("axeyizou"));
        System.out.println(str.findScore("au 123"));
        System.out.println(str.findScore("i3"));
    }
}