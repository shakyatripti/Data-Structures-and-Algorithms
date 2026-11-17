//Problem: https://leetcode.com/problems/long-pressed-name/description/





import java.io.*;
import java.util.*;



class KeyBoardTypedName {
    public boolean isLongPressedName(String name, String typed) {
        int l=0, r=0, m=name.length(), n=typed.length();
        while(l < m && r < n) {
            int count=0, count1=0;
            char ch = name.charAt(l);
            while(l < m && name.charAt(l)==ch) {
                l++;
                count++;
            }

            while(r < n && typed.charAt(r)==ch) {
                r++;
                count1++;
            }

            if(count > count1) {
                return false;
            }
        }
        return l==m && r==n;
    }
}


class Main {
    public static void main(String[] args) {
        KeyBoardTypedName keyboard = new KeyBoardTypedName();
        System.out.println(keyboard.isLongPressedName("alex", "aaleex"));
        System.out.println(keyboard.isLongPressedName("saeed", "ssaaedd"));
        System.out.println(keyboard.isLongPressedName("leelee", "lleeelee"));
        System.out.println(keyboard.isLongPressedName("alex", "aaleexa"));
    }
}