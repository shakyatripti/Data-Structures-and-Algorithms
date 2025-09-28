//Problem: https://leetcode.com/problems/longest-common-prefix/description/





import java.io.*;
import java.util.*;


class LongestCommonPrefix {
    public String findPrefix(String[] strs) {
       int n=strs.length, m=strs[0].length();
        String ans = "";
        for(int i=0; i<m; i++) {
            char ch = strs[0].charAt(i);
            for(int j=1; j<n; j++) {
                if(i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    return ans;
                }
            }
            ans+=ch;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        LongestCommonPrefix str = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(str.findPrefix(strs));
        
        String[] strs1 = {"dog","racecar","car"};
        System.out.println(str.findPrefix(strs1));
        
        String[] strs2 = {"a"};
        System.out.println(str.findPrefix(strs2));
        
        String[] strs3 = {"cab","c"};
        System.out.println(str.findPrefix(strs3));
    }
}