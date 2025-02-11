//Problem: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/

import java.util.*;
import java.io.*;

class RemoveSubStringOccurrences {
    public String removeOccurrences(String s, String part) {
        int index = s.indexOf(part);
        while(index!=-1) {
            s = s.substring(0,index) + s.substring(index + part.length());
            index = s.indexOf(part);
        }
        return s;
    }
}

class Main {
    public static void main(String[] args) {
        String s = "axxxxybxxyy", part = "xy";
        String s1 = "daabcbaabcbc", part1 = "abc";
        RemoveSubStringOccurrences str = new RemoveSubStringOccurrences();
        System.out.println(str.removeOccurrences(s,part));
        System.out.println(str.removeOccurrences(s1,part1));
    }
}