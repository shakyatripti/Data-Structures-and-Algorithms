//Problem: https://leetcode.com/problems/convert-date-to-binary/description/




import java.io.*;
import java.util.*;

class ConvertDate {
    public String toBinary(String date) {
        String ans = "", str="";
        for(char ch: date.toCharArray()) {
            if(ch=='-') {
                ans+=convertToBinary(Integer.valueOf(str));
                ans+="-";
                str="";
            } else {
                str+=ch;
            }
        }
        ans+=convertToBinary(Integer.valueOf(str));
        return ans;
    }

    public String convertToBinary(int n) {
        StringBuilder ans = new StringBuilder();
        while(n!=0) {
            int r=n%2;
            ans.append(r);
            n=n/2;
        }
        ans.reverse();
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        ConvertDate date = new ConvertDate();
        System.out.println(date.toBinary("2080-02-29"));
        System.out.println(date.toBinary("1900-01-01"));
    }
}