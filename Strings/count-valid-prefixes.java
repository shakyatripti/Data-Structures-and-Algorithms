//Problem: https://leetcode.com/problems/count-valid-prefixes/description/




import java.io.*;
import java.util.*;


class ValidPrefixes {
    public int counting (String s) {
        int zeroes = 0, ones = 0, count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='0') {
                zeroes++;
            } else {
                ones++;
            }

            int diff = Math.abs(ones-zeroes);

            if(diff==0 || diff==1) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        ValidPrefixes str = new ValidPrefixes();
        System.out.println(str.counting("00101"));
        System.out.println(str.counting("101"));
    }
}