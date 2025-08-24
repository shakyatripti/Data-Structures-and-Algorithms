//Problem: https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/





import java.io.*;
import java.util.*;

class AcronymOfWord {
    public boolean isAcronym(List<String> words, String s) {
        String str = "";
        for(int i=0; i<words.size(); i++) {
            str+=words.get(i).charAt(0);
        }
        if(str.equals(s)) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        AcronymOfWord str = new AcronymOfWord();
        List<String> words = new ArrayList<>(Arrays.asList("alice","bob","charlie"));
        System.out.println(str.isAcronym(words, "abc"));
        
        List<String> words1 = new ArrayList<>(Arrays.asList("an","apple"));
        System.out.println(str.isAcronym(words1, "a"));
        
        List<String> words2 = new ArrayList<>(Arrays.asList("never","gonna","give","up","on","you"));
        System.out.println(str.isAcronym(words2, "ngguoy"));
    }
}