//Problem: https://leetcode.com/problems/string-matching-in-an-array/description/





//Brute force solution
import java.io.*;
import java.util.*;


class StringMatching {
    public List<String> matched(String[] words) {
        ArrayList<String> substr = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int n=words.length;
        for(int i=0; i<n; i++) {
            int r = words[i].length();
            findSubstrings(words[i], substr);
        }

        for(int i=0; i<n; i++) {
            if(substr.contains(words[i])) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public void findSubstrings(String s, ArrayList<String> substr) {
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<=s.length(); j++) {
                String str = s.substring(i, j);
                if(!substr.contains(str) && str.length() > 0 && str!=s){
                    substr.add(str);
                }
            }
        }
    }
    
    public void display(List<String> arr) {
        if(arr.size()==0) {
            System.out.print("--");
        }
        for(int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public void main(String[] args) {
        StringMatching str = new StringMatching();
        String[] words = {"mass","as","hero","superhero"};
        List<String> ans = str.matched(words);
        str.display(ans);
        
        String[] words1 = {"leetcode","et","code"};
        List<String> ans1 = str.matched(words1);
        str.display(ans1);
        
        String[] words2 = {"blue","green","bu"};
        List<String> ans2 = str.matched(words2);
        str.display(ans2);
    }
}