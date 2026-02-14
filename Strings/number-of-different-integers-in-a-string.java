//Problem: https://leetcode.com/problems/number-of-different-integers-in-a-string/description/




import java.io.*;
import java.util.*;

class DifferentIntegers {
    public int countIntegers(String word) {
        Set<String> st = new HashSet<>();
        String str = "";
        for(char ch: word.toCharArray()) {
            int val = ch - 'a';
            if(val>=0 && val<26) {
                if(str!="") {
                    String s = removeZeroes(str);
                    st.add(s);
                    str = "";
                }
            } else {
                str+=ch;
            }
        }
        if(!str.equals("")) {
            String s = removeZeroes(str);
            st.add(s);
        }
        return st.size();
    }

    public String removeZeroes(String s) {
        int flag=0;
        String ans = "";
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='0' && flag==0) {
                flag=0;
            } else {
                flag=1;
                ans+=s.charAt(i);
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        DifferentIntegers num = new DifferentIntegers();
        System.out.println(num.countIntegers("a123bc34d8ef34"));
        System.out.println(num.countIntegers("leet1234code234"));
        System.out.println(num.countIntegers("a1b01c001"));
        System.out.println(num.countIntegers("167278959591294"));
    }
}