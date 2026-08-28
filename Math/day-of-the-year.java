//Problem:https://leetcode.com/problems/day-of-the-year/description/




import java.io.*;
import java.util.*;

class DayOfTheYear {
    public int findNumberOfDays(String date) {
        int totalDays = 0;
        String[] dateStr = date.split("-");
        int day = Integer.valueOf(dateStr[2]);
        int month = Integer.valueOf(dateStr[1]);
        int year = Integer.valueOf(dateStr[0]);
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for(int i=1; i < month; i++) {
            if(i==2 && isLeapYear(year)) {
                totalDays++;
            }
            totalDays += daysInMonth[i-1];
        }

        totalDays += day;
        return totalDays;
    }

    public boolean isLeapYear(int year) {
        if(year%400==0 || (year%4==0 && year%100!=0)) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        DayOfTheYear date = new DayOfTheYear();

        System.out.println(date.findNumberOfDays("2019-01-09"));
        System.out.println(date.findNumberOfDays("2019-02-10"));
        System.out.println(date.findNumberOfDays("1900-05-02"));
    }
}
