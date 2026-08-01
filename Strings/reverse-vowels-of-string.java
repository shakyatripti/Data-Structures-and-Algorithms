//Problem: https://leetcode.com/problems/reverse-vowels-of-a-string/description/




import java.io.*;
import java.util.*;


class VowelsOfString {
    public String reverse(String s) {
        int k=0;
        String ans = "";
        StringBuilder vowelWord = new StringBuilder("");
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
                vowelWord.append(ch);
            }
        }

        String rev = vowelWord.reverse().toString();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
                ans+=vowelWord.charAt(k);
                k++;
            } else {
                ans+=ch;
            }
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        VowelsOfString str = new VowelsOfString();
        System.out.println(str.reverse("IceCreAm"));
        System.out.println(str.reverse("leetcode"));
    }
}