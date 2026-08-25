//Problem: https://leetcode.com/problems/day-of-the-week/description/




import java.io.*;
import java.util.*;

class DayOfTheWeek {
    public String findDay(int day, int month, int year) {
        int totalDays = 0;
        String[] dayValues = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        for(int i=1971; i<year; i++) {
            if(isLeapYear(i)) {
                totalDays+=366;
            } else {
                totalDays+=365;
            }
        }

        for(int i=1; i<month; i++) {
            totalDays+=daysInMonth[i - 1];
            if(i==2 && isLeapYear(year)) {
                totalDays++;
            }
        }

        totalDays+=day-1;
        return dayValues[totalDays%7];
    }

    public boolean isLeapYear(int year) {
        boolean isLeap = false;
        if((year%4==0 && year%100!=0) || (year%400==0)) {
            isLeap = true;
        }
        return isLeap;
    }
}

class Main {
    public static void main(String[] args) {
        DayOfTheWeek week = new DayOfTheWeek();
        System.out.println(week.findDay(31, 8, 2019));
        System.out.println(week.findDay(18, 7, 1999));
        System.out.println(week.findDay(15, 8, 1993));
    }
}
