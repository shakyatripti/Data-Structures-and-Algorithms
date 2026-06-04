//Problem: https://leetcode.com/problems/determine-if-string-halves-are-alike/description/




import java.io.*;
import java.util.*;


class HalvesAreAlike {
    public boolean containsVowel(String s) {
        int n = s.length();
        String a = s.substring(0, n/2);
        String b = s.substring(n/2, n);
        int c1 = countVowels(a);
        int c2 = countVowels(b);
        if(c1==c2) {
            return true;
        }
        return false;
    }

    public int countVowels(String s) {
        int total = 0;
        for(char ch: s.toCharArray()) {
            if(ch=='a' || ch=='e' || ch=='o' || ch=='u' || ch=='i' || ch=='A' || ch=='E' || ch=='O' || ch=='U' || ch=='I') {
                total++;
            }
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        HalvesAreAlike str = new HalvesAreAlike();
        System.out.println(str.containsVowel("book"));
        System.out.println(str.containsVowel("textbook"));
    }
}