//Problem: https://leetcode.com/problems/rearrange-spaces-between-words/description/





import java.io.*;
import java.util.*;


class Sentences {
    public String reorderSpaces(String text) {
        int spaces = 0, n = text.length(), words = 0, i = 0, evenSpace = 0, extraSpace = 0;
        String ans = "";
        ArrayList<String> wordsFormed = new ArrayList<>();
        while(i<n) {
            if(text.charAt(i)==' ') {
                spaces++;
                i++;
            } else {
                String str = "";
                while(i < n && text.charAt(i)!=' ') {
                    str+=text.charAt(i);
                    i++;
                }
                wordsFormed.add(str);
                words++;
            }
        }

        if(words > 1) {
            evenSpace = spaces/(words-1);
            extraSpace = spaces%(words-1);
        } else {
            extraSpace = spaces;
        }

        for(int j=0; j<wordsFormed.size()-1; j++) {
            ans+=wordsFormed.get(j);
            int m = evenSpace;
            while(m!=0) {
                ans+=" ";
                m--;
            }
        }
        ans+=wordsFormed.get(wordsFormed.size()-1);
        while(extraSpace!=0) {
            ans+=" ";
            extraSpace--;
        }

        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        Sentences str = new Sentences();
        String text = "  this   is  a sentence ";
        System.out.println(str.reorderSpaces(text));
        
        String text1 = " practice   makes   perfect";
        System.out.println(str.reorderSpaces(text1));
        
        String text2 = "  hello";
        System.out.println(str.reorderSpaces(text2));
    }
}