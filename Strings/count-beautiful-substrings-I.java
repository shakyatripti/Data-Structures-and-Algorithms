//Problem: https://leetcode.com/problems/count-beautiful-substrings-i/description/





import java.io.*;
import java.util.*;

class BeautifulSubstringsI {
    public int count(String s, int k) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            int vowels=0, consonants=0;
            for(int j=i; j<s.length(); j++) {
                char ch = s.charAt(j);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                    vowels++;
                } else {
                    consonants++;
                }

                if((vowels==consonants) && (vowels*consonants)%k==0) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        BeautifulSubstringsI str = new BeautifulSubstringsI();
        System.out.println(str.count("baeyh", 2));
        System.out.println(str.count("abba", 1));
        System.out.println(str.count("bcdf", 1));
    }
}