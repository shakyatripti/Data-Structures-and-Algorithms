//Problem: https://leetcode.com/problems/valid-word/description/




import java.io.*;
import java.util.*;

class ValidWord {
    public boolean isValid(String word) {
        if(word.length() < 3) {
            return false;
        }
        int vowel=0, consonant=0, digit=0, symbol=0;
        for(char ch: word.toCharArray()) {
            int val = ch-'0';
            if(ch=='a' || ch=='e' || ch=='o' || ch=='u' || ch=='i' || ch=='A' || ch=='E' ||
               ch=='O' || ch=='U' || ch=='I') {
                vowel=1;
            } else {
                if((val >= 49 && val <= 74) || (val >= 17 && val <=42)){
                    consonant=1;
                }
                else if(val >= 0 && val <= 9) {
                    digit = 1;
                } else {
                    symbol = 1;
                }
            }
        }
        if(consonant==0 || vowel==0 || symbol==1) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        ValidWord word = new ValidWord();
        System.out.println(word.isValid("a34@ebc"));
        System.out.println(word.isValid("ebbbAz99"));
        System.out.println(word.isValid("b5"));
        System.out.println(word.isValid("8$bncmae"));
        System.out.println(word.isValid("772BEL"));
    }
}