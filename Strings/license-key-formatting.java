//Problem: https://leetcode.com/problems/license-key-formatting/description/




import java.io.*;
import java.util.*;


class LicenseKey {
    public String formatting(String s, int k) {
        int count = 0;
        String ans = "";
        for(char ch: s.toCharArray()) {
            int val = ch - 'a';
            if(ch!='-') {
                ans+=ch;
            }
        }
        String upper = ans.toUpperCase();
        StringBuilder str = new StringBuilder("");
        for(int i=upper.length()-1; i>=0; i--) {
            if(count==k) {
                str.append('-');
                count=0;
            }
            count++;
            str.append(upper.charAt(i));
        }
        str.reverse();
        return str.toString();
    }
}

class Main {
    public static void main(String[] args) {
        LicenseKey license = new LicenseKey();
        System.out.println(license.formatting("5F3Z-2e-9-w", 4));
        System.out.println(license.formatting("2-5g-3-J", 2));
    }
}