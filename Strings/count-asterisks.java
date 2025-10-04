//Problem: https://leetcode.com/problems/count-asterisks/description/



import java.io.*;
import java.util.*;


class CountAsterisks {
    public int count(String s) {
        String[] words = s.split("\\|");
        int count=0;
        for(int i=0; i<words.length; i++) { 
            if(i%2==0) {
                for(int j=0; j<words[i].length(); j++) {
                    char ch=words[i].charAt(j);
                    if(ch=='*') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        CountAsterisks str = new CountAsterisks();
        System.out.println(str.count("l|*e*et|c**o|*de|"));
        System.out.println(str.count("iamprogrammer"));
        System.out.println(str.count("yo|uar|e**|b|e***au|tifu|l"));
    }
}
