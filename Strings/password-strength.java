//Problem: https://leetcode.com/problems/password-strength/description/




import java.io.*;
import java.util.*;


class PasswordStrength {
    public int calcStrength (String password) {
        int totalStrength = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int[] digit = new int[10];
        int s1 = 0, s2 = 0, s3 = 0, s4 = 0;
        for(char ch: password.toCharArray()) {
            int val = ch - 'a';
            int val1 = ch - 'A';
            int val2 = ch - '0';
            if(val>=0 && val<=25) {
                freq1[val]++;
            }
            if(val1>=0 && val1<=25) {
                freq2[val1]++;
            }
            if(val2>=0 && val2<=9) {
                digit[val2]++;
            }
            if(ch=='!') {
                s1 = 1;
            }
            if(ch=='@') {
                s2 = 1;
            }
            if(ch=='#') {
                s3 = 1;
            }
            if(ch=='$') {
                s4 = 1;
            }
        }

        for(int i=0; i<26; i++) {
            if(i>=0 && i<=9) {
                if(digit[i]!=0) {
                    totalStrength+=3;
                }
            }
            if(freq1[i]!=0) {
                totalStrength++;
            }
            if(freq2[i]!=0) {
                totalStrength+=2;
            }
        }
        totalStrength+=(s1 + s2 + s3 + s4)*5;
        return totalStrength;
    }
}

class Main {
    public static void main(String[] args) {
        PasswordStrength pswd = new PasswordStrength();
        System.out.println(pswd.calcStrength("aA1!"));
        System.out.println(pswd.calcStrength("bbB11#"));
    }
}