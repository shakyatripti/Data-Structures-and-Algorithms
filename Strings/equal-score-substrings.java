//Problem: https://leetcode.com/problems/equal-score-substrings/description/





import java.io.*;
import java.util.*;

class EqualScoreSubstrings {
    public boolean scoreBalance(String s) {
        int score=0, curr=0;
        for(char ch: s.toCharArray()) {
            score+=ch-'a'+1;
        }

        for(int j=0; j<s.length(); j++) {
            curr+=s.charAt(j)-'a' + 1;
            int rem = score - curr;
            if(rem==curr) {
                return true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        EqualScoreSubstrings str = new EqualScoreSubstrings();
        System.out.println(str.scoreBalance("adbc"));
        System.out.println(str.scoreBalance("acdb"));
        System.out.println(str.scoreBalance("bace"));
    }
}