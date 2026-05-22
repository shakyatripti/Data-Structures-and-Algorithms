//Problem: https://leetcode.com/problems/strong-password-checker-ii/description/




import java.io.*;
import java.util.*;

class PasswordCheckerII {
    public boolean isStrong(String password) {
        boolean containsUpper = false, containsLower = false, containsDigit = false, containsSpecial = false, containsAdj = false;
        if(password.length() < 8) {
            return false;
        }
        for(int i=0; i<password.length(); i++) {
            char ch = password.charAt(i);
            int upper = ch - 'A';
            int lower = ch - 'a';
            int digit = ch - '0';
            if(upper>=0 && upper<=25) {
                containsUpper = true;
            }
            if(lower>=0 && lower<=25) {
                containsLower = true;
            }
            if(digit>=0 && digit<=9) {
                containsDigit = true;
            }
            if(("!@#$%^&*()-+").contains(String.valueOf(ch))) {
                containsSpecial = true;
            }
            if(i < password.length() - 1 &&ch==password.charAt(i+1)) {
                containsAdj = true;
            }
        }
        if(!containsSpecial || containsAdj || !containsLower || !containsUpper || !containsDigit) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        PasswordCheckerII pswd = new PasswordCheckerII();
        System.out.println(pswd.isStrong("IloveLe3tcode!"));
        System.out.println(pswd.isStrong("Me+You--IsMyDream"));
        System.out.println(pswd.isStrong("1aB!"));
        System.out.println(pswd.isStrong("AaZzBc89!@#)"));
    }
}