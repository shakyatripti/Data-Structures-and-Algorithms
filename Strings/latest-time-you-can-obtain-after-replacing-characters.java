//Problem:
https://leetcode.com/problems/latest-time-you-can-obtain-after-replacing-characters/description/





import java.io.*;
import java.util.*;



class LatestTime {
    public String replaceCharacters(String s) {
        String ans = "";
        String[] time = s.split("\\:");
        char h1 = time[0].charAt(0), h2 = time[0].charAt(1);
        char m1 = time[1].charAt(0), m2 = time[1].charAt(1);
        if((h1=='?' && h2=='?') || (h2=='?' && h1 == '1')) {
            ans+="11";
        } else if(h1=='?' && Integer.valueOf(h2-'0') > 1) {
            ans+='0';
            ans+=h2;
        }else if(h1=='?' && (h2=='1' || h2=='0')) {
            ans+='1';
            ans+=h2;
        } else if(h2=='?' && h1 == '0') {
            ans+="09";
        } else {
            ans+=h1;
            ans+=h2;
        }

        ans+=":";

        if(m1=='?' && m2=='?') {
            ans+="59";
        } else if(m1=='?' && m2!='?') {
            ans+='5';
            ans+=m2;
        } else if(m1!='?' && m2=='?') {
            ans+=m1;
            ans+='9';
        } else {
            ans+=m1;
            ans+=m2;
        }
        return ans;
    }
}


class Main {
    public static void main(String[] args) {
        LatestTime time = new LatestTime();
        System.out.println(time.replaceCharacters("1?:?4"));
        System.out.println(time.replaceCharacters("0?:5?"));
        System.out.println(time.replaceCharacters("?1:?6"));
        System.out.println(time.replaceCharacters("1?:30"));
        System.out.println(time.replaceCharacters("08:33"));
    }
}