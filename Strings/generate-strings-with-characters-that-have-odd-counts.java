//Problem: https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/description/




import java.io.*;
import java.util.*;

class OddCountCharacters {
    public String generateTheString(int n) {
        String ans = "";
        for(int i=0; i<n-1; i++) {
            ans+="a";
        }
        if(n%2==0) {
            ans+="b";
        } else {
            ans+="a";
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        OddCountCharacters str = new OddCountCharacters();
        System.out.println(str.generateTheString(4));
        System.out.println(str.generateTheString(2));
        System.out.println(str.generateTheString(7));
    }
}