//Problem: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/




import java.io.*;
import java.util.*;

class DistinctCharSubstrings {
    public int countSubstrings(String s) {
        int n=s.length(), count=0;
        for(int i=0; i<=n-3; i++) {
           char ch = s.charAt(i);
           char ch1 = s.charAt(i+1);
           char ch2 = s.charAt(i+2);
            if(ch!=ch1 && ch1!=ch2 && ch2!=ch) {
                count++;
            }
        }
        return count;
    }
}


class Main {
    public static void main(String[] args) {
       DistinctCharSubstrings str = new DistinctCharSubstrings();
       System.out.println(str.countSubstrings("xyzzaz"));
System.out.println(str.countSubstrings("aababcabc"));
    }
}
