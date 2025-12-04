//Problem: https://leetcode.com/problems/keyboard-row/description/





import java.io.*;
import java.util.*;

class KeyboardRow {
    public String[] findWords(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        int[] score = new int[26];
        score = setRow(score, 1, "asdfghjkl");
        score = setRow(score, 2, "zxcvbnm");
        for(int i=0; i<words.length; i++) {
            String str = words[i].toLowerCase();
            int row = score[str.charAt(0)-'a'];
            int flag = 0;
            for(int j=0; j<str.length(); j++) {
                if(score[str.charAt(j)-'a']!=row) {
                    flag=1;
                    break;
                }
            }
            if(flag==0) {
                ans.add(words[i]);
            }
        }

        String[] res = new String[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public int[] setRow(int[] score, int r, String s) {
        for(int i=0; i<s.length(); i++) {
            score[s.charAt(i)-'a'] = r;
        }
        return score;
    }
    
    public void display(String[] ans) {
        if(ans.length==0) {
            System.out.print("-");
        }
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] +  " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        KeyboardRow keyboard = new KeyboardRow();
        String[] words = {"Hello","Alaska","Dad","Peace"};
        String[] ans = keyboard.findWords(words);
        keyboard.display(ans);
        
        String[] words1 = {"omk"};
        String[] ans1 = keyboard.findWords(words1);
        keyboard.display(ans1);
        
        String[] words2 = {"adsdf","sfd"};
        String[] ans2 = keyboard.findWords(words2);
        keyboard.display(ans2);
    }
}