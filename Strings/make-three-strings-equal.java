//Problem: https://leetcode.com/problems/make-three-strings-equal/description/





import java.io.*;
import java.util.*;


class ThreeStringsEqual {
    public int findMinOperations(String s1, String s2, String s3) {
        int a = s1.length(), b = s2.length(), c = s3.length(), n = Math.min(a, Math.min(b, c)), count = 0, i = 0;
        for(i=0; i<n; i++) {
            char ch = s1.charAt(i);
            char ch1 = s2.charAt(i);
            char ch2 = s3.charAt(i);
            if(ch!=ch1 || ch1!=ch2) {
                break;
            }
        }
        count = (a-i) + (b-i) + (c-i);
        return i==0 ? -1 : count;
    }
}

class Main {
    public static void main(String[] args) {
        ThreeStringsEqual str = new ThreeStringsEqual();
        System.out.println(str.findMinOperations("abc", "abb", "ab"));
        System.out.println(str.findMinOperations("dac", "bac", "cac"));
    }
}