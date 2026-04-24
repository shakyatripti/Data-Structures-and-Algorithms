//Problem: https://leetcode.com/problems/reformat-phone-number/description/






import java.io.*;
import java.util.*;

class PhoneNumber {
    public String reformatNumber(String number) {
        int len = 0;
        StringBuilder ans = new StringBuilder("");
        StringBuilder num = new StringBuilder("");
        for(char ch: number.toCharArray()) {
            int val = ch - '0';
            if(val>=0 && val<=9) {
                num.append(ch);
                len++;
            }
        }
        if(len<=3) {
            return number;
        }
        int k = len/3, i=0;
        while(k!=0) {
            ans.append(num.charAt(i));
            ans.append(num.charAt(i+1));
            ans.append(num.charAt(i+2));
            if(k!=1) {
                ans.append('-');
            }
            i+=3;
            k--;
        }
        int rem = len - i;
        if(rem==1) {
            ans.deleteCharAt(ans.length()-1);
            ans.append('-');
            i--;
            ans.append(num.charAt(i));
            ans.append(num.charAt(i+1));
        }
        if(rem==2) {
            ans.append('-');
            ans.append(num.charAt(i));
            ans.append(num.charAt(i+1));
        }
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        PhoneNumber phone = new PhoneNumber();
        System.out.println(phone.reformatNumber("1-23-45 6 78910"));
        System.out.println(phone.reformatNumber("123 4-567"));
        System.out.println(phone.reformatNumber("123 4-5678"));
        System.out.println(phone.reformatNumber("1-23-45 6"));
        System.out.println(phone.reformatNumber("12"));
    }
}