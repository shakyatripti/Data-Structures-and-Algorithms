//Problem: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/




import java.io.*;
import java.util.*;

class FirstOccurrence {
    public int findIndex(String haystack, String needle) {
        for(int i=0; i<haystack.length(); i++) {
            for(int j=i; j<=haystack.length(); j++) {
                String str = haystack.substring(i, j);
                if(str.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        FirstOccurrence str = new FirstOccurrence();
        System.out.println(str.findIndex("sadbutsad","sad"));
        System.out.println(str.findIndex("leetcode", "leeto"));
        System.out.println(str.findIndex("testurlrtiurl", "url"));
    }
}