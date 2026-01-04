//Problem: https://leetcode.com/problems/largest-even-number/description/





import java.io.*;
import java.util.*;

class EvenNumber {
    public String findLargest(String s) {
        int i=s.length()-1;
        while(i >= 0) {
            if(s.charAt(i)=='2') {
                break;
            } else {
                i--;
            }
        }
        return s.substring(0, i+1);
    }
}

class Main {
    public static void main(String[] args) {
        EvenNumber num = new EvenNumber();
        System.out.println(num.findLargest("1112"));
        System.out.println(num.findLargest("221"));
        System.out.println(num.findLargest("1"));
    }
}