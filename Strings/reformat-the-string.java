//Problem: https://leetcode.com/problems/reformat-the-string/description/





import java.io.*;
import java.util.*;


class ReformatString {
    public String finalString (String s) {
        ArrayList<Character> digits = new ArrayList<>();
        ArrayList<Character> letters = new ArrayList<>();
        String ans = "";
        if(s.length()==1) {
            return s;
        }
        for(int i=0; i<s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if(val>=0 && val < 26) {
                letters.add(s.charAt(i));
            } else {
                digits.add(s.charAt(i));
            }
        }

        int n = digits.size(), m = letters.size();
        if(n==0 || m==0) {
            return "-";
        }

        if((m - n == 1) || (m - n == 0)) {
            ans = findPermutation(digits, letters);
        }
        if((n - m == 1) || (n - m == 0)) {
            ans = findPermutation(letters, digits);
        }
        return ans.length()==0 ? "-" : ans;
    }

    public String findPermutation(ArrayList<Character> s, ArrayList<Character> t) {
        int k=0;
        String ans = "";
        for(k=0; k<s.size(); k++) {
            ans+=t.get(k);
            ans+=s.get(k);
        }

        if(k < t.size()) {
            ans+=t.get(k);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ReformatString str = new ReformatString();
        System.out.println(str.finalString("a0b1c2"));
        System.out.println(str.finalString("leetcode"));
        System.out.println(str.finalString("1229857369"));
        System.out.println(str.finalString("covid2019"));
        System.out.println(str.finalString("j"));
        System.out.println(str.finalString("a12bcd"));
    }
}