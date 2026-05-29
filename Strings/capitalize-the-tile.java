//Problem: https://leetcode.com/problems/capitalize-the-title/description/



import java.io.*;
import java.util.*;


class Title {
    public String capitalize(String title) {
        String ans="";
        String[] words = title.split("\\ ");
        int m=words.length;
        for(int i=0; i<words.length; i++) {
            int n = words[i].length();
            if(n >= 3) {
                String str = words[i].substring(0,1).toUpperCase();
                str+=words[i].substring(1, n).toLowerCase();
                if(i!=m-1) {
                    str+=" ";
                }
                ans+=str;
            } else {
                String str = words[i].toLowerCase();
                if(i!=m-1) {
                    str+=" ";
                }
                ans+=str;
            }
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        Title str = new Title();
        System.out.println(str.capitalize("capiTalIze tHe titLe"));
        System.out.println(str.capitalize("First leTTeR of EACH Word"));
        System.out.println(str.capitalize("i lOve leetcode"));
    }
}