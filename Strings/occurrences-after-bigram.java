//Problem: https://leetcode.com/problems/occurrences-after-bigram/description/





import java.io.*;
import java.util.*;

class Bigram {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> arr = new ArrayList<>();
        String[] words = text.split("\\ ");
        int n=words.length;
        for(int i=0; i<n; i++) {
            if(words[i].equals(first) && (i+1 < n-1) && words[i+1].equals(second)) {
                arr.add(words[i+2]);
            }
        }
        
        String[] ans = new String[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
    
    public void display(String[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Bigram str = new Bigram();
        String[] ans = str.findOcurrences("alice is a good girl she is a good student","a", "good");
        str.display(ans);
        
        String[] ans1 = str.findOcurrences("we will we will rock you", "we", "will");
        str.display(ans1);
        
        String[] ans2 = str.findOcurrences("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa","kcyxdfnoa", "jkypmsxd");
        str.display(ans2);
    }
}