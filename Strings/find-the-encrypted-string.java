//Problem: https://leetcode.com/problems/find-the-encrypted-string/description/




import java.io.*;
import java.util.*;

class EncryptedString {
    public String getString(String s, int k) {
        String ans = "";
        int n=s.length();
        for(int i=0; i<s.length(); i++) {
            int index = (i+k)%n;
            ans+=s.charAt(index);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        EncryptedString str = new EncryptedString();
        System.out.println(str.getString("dart", 3));
        System.out.println(str.getString("aaa", 1));
    }
}