//Problem: https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/description/




import java.io.*;
import java.util.*;

class EqualStringsI {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.charAt(0)!=s2.charAt(0) && s1.charAt(0)!=s2.charAt(2)) {
            return false;
        }

        if(s1.charAt(1)!=s2.charAt(1) && s1.charAt(1)!=s2.charAt(3)) {
            return false;
        }

        if(s1.charAt(2)!=s2.charAt(2) && s1.charAt(2)!=s2.charAt(0)) {
            return false;
        }

        if(s1.charAt(3)!=s2.charAt(3) && s1.charAt(3)!=s2.charAt(1)) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        EqualStringsI str = new EqualStringsI();
        System.out.println(str.canBeEqual("abcd", "cdab"));
        System.out.println(str.canBeEqual("abcd", "dacb"));
        System.out.println(str.canBeEqual("cmpr", "rmcp"));
    }
}