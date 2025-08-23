//Problem: https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/description/





import java.io.*;
import java.util.*;

class VowelStrings {
    public int count(String[] words, int left, int right) {
        int count = 0;
        for(int i=left; i<=right; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length()-1);
            if((start=='a' || start=='e' || start=='i' || start=='o' || start=='u') && (end=='a' || end=='e' || end=='u' || end=='i' || end=='o')) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main (String[] args) {
        VowelStrings str = new VowelStrings();
        String[] words = {"are","amy","u"};
        System.out.println(str.count(words, 0, 2));
        
        String[] words1 = {"hey","aeo","mu","ooo","artro"};
        System.out.println(str.count(words1, 1, 4));
    }
}