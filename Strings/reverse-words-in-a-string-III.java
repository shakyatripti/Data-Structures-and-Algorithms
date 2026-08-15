//Problem: https://leetcode.com/problems/reverse-words-in-a-string-iii/description/




import java.io.*;
import java.util.*;


class ReverseWordsIII {
    public String reverse(String s) {
        String ans = "";
        String[] words = s.split("\\ ");
        int n=words.length;
        for(int i=0; i<n; i++) {
            StringBuilder str = new StringBuilder(words[i]);
            ans+=str.reverse().toString();
            if(i!=n-1) {
                ans+=" ";
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ReverseWordsIII words = new ReverseWordsIII();
        System.out.println(words.reverse("Let's take LeetCode contest"));
        System.out.println(words.reverse("Mr Ding"));
    }
}