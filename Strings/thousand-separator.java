//Problem: https://leetcode.com/problems/thousand-separator/description/




import java.io.*;
import java.util.*;

class ThousandSeparator {
    public String separate(int n) {
        String s = String.valueOf(n);
        StringBuilder str = new StringBuilder();
        int m=s.length(), count=0, i=m-1;
        while(i >= 0) {
            str.append(s.charAt(i));
            count++;
            i--;
            if(count==3 && i >= 0) {
                str.append(".");
                count = 0;
            }
        }
        return str.reverse().toString();
    }
}

class Main {
    public static void main(String[] args) {
        ThousandSeparator num = new ThousandSeparator();
        System.out.println(num.separate(987));
        System.out.println(num.separate(1234));
    }
}