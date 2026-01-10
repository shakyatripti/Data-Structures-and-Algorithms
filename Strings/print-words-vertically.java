//Problem: https://leetcode.com/problems/print-words-vertically/description/




import java.io.*;
import java.util.*;


class VerticalWords {
    public List<String> printVertically(String s) {
        List<String> ans = new ArrayList<String>();
        String[] words = s.split("\\ ");
        int m=0, n=words.length, p=0, q=0;
        for(int i=0; i<words.length; i++) {
            m=Math.max(words[i].length(), m);
        }
        
        for(int i=0; i<m; i++) {
            StringBuilder str = new StringBuilder("");
            for(int j=0; j<n; j++) {
                if(i < words[j].length()) {
                    str.append(words[j].charAt(i));
                } else {
                    str.append(' ');
                }
            }
            ans.add(str.toString().stripTrailing());
        }
        return ans;
    }
    
    public void display(List<String> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + ",");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        VerticalWords words = new VerticalWords();
        List<String> ans = words.printVertically("HOW ARE YOU");
        words.display(ans);
        
        List<String> ans1 = words.printVertically("TO BE OR NOT TO BE");
        words.display(ans1);
        
        List<String> ans2 = words.printVertically("CONTEST IS COMING");
        words.display(ans2);
    }
}