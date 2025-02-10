//Problem: https://leetcode.com/problems/clear-digits/description/


//Brute force solution
import java.util.*;
import java.io.*;

class ClearDigits {
    public String nonDigits(String s) {
        String ans = "", res = "";
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch-'0'>=0 && ch-'0'<=9) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        while(!st.isEmpty()) {
            ans+=st.pop();
        }
        for(int i=ans.length()-1; i>=0; i--) {
            res+=ans.charAt(i);
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        String s = "a4bcd99";
        ClearDigits str = new ClearDigits();
        System.out.println(str.nonDigits(s));
    }
}


//Optimal solution
import java.util.*;
import java.io.*;

class ClearDigits {
    public String nonDigits(String s) {
        StringBuilder ans = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(ch-'0'>=0 && ch-'0'<=9) {
                if(ans.length() > 0) {
                    ans.deleteCharAt(ans.length()-1);
                }
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        String s = "a4bcd99";
        String s1 = "bhcsre";
        ClearDigits str = new ClearDigits();
        System.out.println(str.nonDigits(s));
        System.out.println(str.nonDigits(s1));
    }
}