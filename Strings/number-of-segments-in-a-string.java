//Problem: https://leetcode.com/problems/number-of-segments-in-a-string/description/




import java.io.*;
import java.util.*;


class StringSegments {
    public int count(String s) {
        int count = 0;
        if(s.length()==0) {
            return 0;
        }
        String[] words = s.split("\\ ");
        for(int i=0; i<words.length; i++) {
            if(words[i].length() > 0 && words[i].charAt(0)!=' ') {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        StringSegments seg = new StringSegments();
        System.out.println(seg.count("Hello, my name is John"));
        System.out.println(seg.count("Hello"));
        System.out.println(seg.count(""));
        System.out.println(seg.count(", , , ,        a, eaefa"));
    }
}