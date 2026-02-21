//Problem: https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/description/




import java.io.*;
import java.util.*;


class MakeBinaryStringBeautiful {
    public int minChanges(String s) {
        int count = 0;
        for(int i=0; i<=s.length()-2; i+=2) {
            if(s.charAt(i)!=s.charAt(i+1)) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        MakeBinaryStringBeautiful str = new MakeBinaryStringBeautiful();
        System.out.println(str.minChanges("1001"));
        System.out.println(str.minChanges("10"));
        System.out.println(str.minChanges("0000"));
    }
}