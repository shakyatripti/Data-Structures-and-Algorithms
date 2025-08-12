//Problem: https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/




import java.io.*;
import java.util.*;

class EqualDigits {
    public boolean hasSameDigits(String s) {
        String ans = "";
        while(ans.length()!=2) {
            ans = removeDigits(s);
            s = ans;
        }
        if(s.charAt(0)==s.charAt(1)) {
            return true;
        }
        return false;
    }

    public String removeDigits(String s) {
        String ans = "";
        for(int i=0; i<s.length()-1; i++) {
            int first = s.charAt(i) - '0';
            int second = s.charAt(i+1) - '0';
            int sum = (first + second) % 10;
            ans+=String.valueOf(sum);
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        EqualDigits num = new EqualDigits();
        System.out.println(num.hasSameDigits("3902"));
        System.out.println(num.hasSameDigits("34789"));
    }
}