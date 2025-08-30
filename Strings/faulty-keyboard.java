//Problem: https://leetcode.com/problems/faulty-keyboard/description/




import java.io.*;
import java.util.*;

class FaultyKeyboard {
    public String finalString(String s) {
        StringBuilder str = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(ch=='i') {
                str.reverse();
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}

class Main {
    public static void main(String[] args) {
        FaultyKeyboard keyboard = new FaultyKeyboard();
        System.out.println(keyboard.finalString("string"));
        System.out.println(keyboard.finalString("poiinter"));
    }
}