//Problem: https://leetcode.com/problems/find-special-substring-of-length-k/description/




import java.io.*;
import java.util.*;


class SpecialSubstring {
    public boolean hasKlength(String s, int k) {
        int n = s.length();
        for(int i=0; i<=n-k; i++) {
            ArrayList<Character> arr = new ArrayList<>();
            for(int j=i; j<i+k; j++) {
                if(!arr.contains(s.charAt(j))) {
                    arr.add(s.charAt(j));
                }
            }
            if(arr.size()==1) {
                char ch = arr.get(0);
                boolean left = true, right = true;
                if(i - 1 >= 0) {
                    char prev = s.charAt(i-1);
                    if(ch!=prev) {
                        left = true;
                    } else {
                        left = false;
                    }
                }
                if(i+k < n) {
                    char next = s.charAt(i+k);
                    if(ch!=next) {
                        right = true;
                    } else {
                        right = false;
                    }
                }

                if(right && left) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        SpecialSubstring substr = new SpecialSubstring();
        System.out.println(substr.hasKlength("aaabaaa", 3));
        System.out.println(substr.hasKlength("abc", 2));
        System.out.println(substr.hasKlength("ccc", 2));
    }
}