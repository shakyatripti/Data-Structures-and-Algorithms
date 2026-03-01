//Problem: https://leetcode.com/problems/trim-trailing-vowels/description/





import java.io.*;
import java.util.*;

class TrailingVowels {
    public String trim(String s) {
        int n = s.length(), i=n-1;
        String ans = "";
        while(i >= 0) {
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                i--;
            } else {
                break;
            }
        }
        for(int j=0; j<=i; j++) {
            ans+=s.charAt(j);
        }
        return ans;
        
    }
}

class Main {
    public static void main(String[] args) {
        TrailingVowels str = new TrailingVowels();
        System.out.println(str.trim("idea"));
        System.out.println(str.trim("aeiou"));
        System.out.println(str.trim("day"));
    }
}