//Problem: https://leetcode.com/problems/reformat-date/description/



import java.io.*;
import java.util.*;


class ReformatDate {
    public String formatting(String date) {
        String[] fullDate = date.split("\\ ");
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String ans = "";
        ans+=fullDate[2] + "-";
        for(int i=0; i<months.length; i++) {
            if(months[i].equals(fullDate[1])) {
                if((i+1) < 10) {
                    ans+="0";
                }
                ans+=(i + 1) + "-";
            }
        }
        int day = Integer.valueOf(fullDate[0].replaceAll("\\D+", ""));
        if(day < 10) {
            ans+="0";
        }
        ans+=day;
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ReformatDate str = new ReformatDate();
        System.out.println(str.formatting("20th Oct 2052"));
        System.out.println(str.formatting("6th Jun 1933"));
        System.out.println(str.formatting("26th May 1960"));
        System.out.println(str.formatting("20th Sep 1958"));
    }
}