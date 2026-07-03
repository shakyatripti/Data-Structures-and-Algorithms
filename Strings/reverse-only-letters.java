//Problem: https://leetcode.com/problems/reverse-only-letters/description/





import java.io.*;
import java.util.*;

class OnlyLetters {
    public String reverse(String s) {
        String ans = "";
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            int val = ch - 'a';
            int val2 = ch - 'A';
            if(val>=0 && val<26) {
                st.add(ch);
            }
            if(val2>=0 && val2<26) {
                st.add(ch);
            }
        }

        for(char ch: s.toCharArray()) {
            int val = ch - 'a';
            int val2 = ch - 'A';
            if((val>=0 && val<26) || (val2>=0 && val2<26)){
                ans+=st.pop();
            } else {
                ans+=ch;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        OnlyLetters str = new OnlyLetters();
        System.out.println(str.reverse("ab-cd"));
        System.out.println(str.reverse("a-bC-dEf-ghIj"));
        System.out.println(str.reverse("Test1ng-Leet=code-Q!"));
    }
}