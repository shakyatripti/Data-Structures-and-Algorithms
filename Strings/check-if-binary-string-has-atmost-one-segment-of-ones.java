//Problem: https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description/





import java.io.*;
import java.util.*;

class BinaryString {
    public boolean checkOnesSegment(String s) {
        int c1=0, flag=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='1') {
                if(flag==1) {
                    return false;
                }
                c1++;
            } else {
                flag=1;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        BinaryString str = new BinaryString();
        System.out.println(str.checkOnesSegment("1001"));
        System.out.println(str.checkOnesSegment("110"));
        System.out.println(str.checkOnesSegment("111011"));
    }
}