//Problem: https://leetcode.com/problems/detect-capital/description/




import java.io.*;
import java.util.*;


class DetectCapital {
    public boolean isRight(String word) {
        String org = word;
        String upper = word.toUpperCase();
        String lower = word.toLowerCase();
        if(upper.equals(org) || lower.equals(org)) {
            return true;
        }
        for(int i=0; i<org.length(); i++) {
            int val = org.charAt(i) - 'a';
            if(i!=0 && val < 0) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        DetectCapital capital = new DetectCapital();
        System.out.println(capital.isRight("USA"));
        System.out.println(capital.isRight("FlaG"));
        System.out.println(capital.isRight("Car"));
    }
}