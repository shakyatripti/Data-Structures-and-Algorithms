//Problem: https://leetcode.com/problems/reverse-degree-of-a-string/description/





import java.io.*;
import java.util.*;

class DegreeOfString {
    public int reverse(String s) {
        int reversed = 0;
        for(int i=0; i<s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            reversed+=(26-ch)*(i+1);
        }
        return reversed;
    }
}

class Main {
    public static void main(String[] args) {
        DegreeOfString str = new DegreeOfString();
        System.out.println(str.reverse("abc"));
        System.out.println(str.reverse("zaza"));
    }
}