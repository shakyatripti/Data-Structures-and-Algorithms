//Problem: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/


//Brute force approach
import java.util.*;
import java.io.*;

class StringsAreEqual {
    public boolean areStringsEqual(String s1, String s2) {
        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();
        countChar(s1,mp1);
        countChar(s2,mp2);
        for(int i=0; i<s1.length(); i++) {
            if(mp1.get(s1.charAt(i)) != mp2.get(s1.charAt(i))) {
                return false;
            }
        }
        int count = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                count++;
            }
        }
        return count==0 || count==2 ? true: false;
    }
    
    public void countChar(String s, HashMap<Character,Integer> mp) {
        for(char ch: s.toCharArray()) {
            if(mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch)+1);
            } else {
                mp.put(ch, 0);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        String s1 ="siyolsdcjthwsiplccjbuceoxmpjgrauocx";
        String s2 = "siyolsdcjthwsiplccpbuceoxmjjgrauocx";
        String s3 = "bank";
        String s4 = "kant";
        StringsAreEqual s = new StringsAreEqual();
        System.out.println(s.areStringsEqual(s1,s2));
        System.out.println(s.areStringsEqual(s3,s4));
    }
}

//Optimal Approach
import java.util.*;
import java.io.*;

class StringsAreEqual {
    public boolean areStringsEqual(String s1, String s2) {
        int i=-1, j=-1, count=0;
        for(int m=0; m<s1.length(); m++) {
            if(s1.charAt(m)!=s2.charAt(m)) {
                count++;
                if(i==-1) {
                    i=m;
                } else if(j==-1) {
                    j=m;
                }
            }
        }
        if(count==0 || (count==2 && s1.charAt(i)==s2.charAt(j) && s1.charAt(j)==s2.charAt(i))) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        String s1 ="siyolsdcjthwsiplccjbuceoxmpjgrauocx";
        String s2 = "siyolsdcjthwsiplccpbuceoxmjjgrauocx";
        String s3 = "bank";
        String s4 = "kant";
        StringsAreEqual s = new StringsAreEqual();
        System.out.println(s.areStringsEqual(s1,s2));
        System.out.println(s.areStringsEqual(s3,s4));
    }
}