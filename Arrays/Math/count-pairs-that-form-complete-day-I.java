//Problem: https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i/description/




import java.io.*;
import java.util.*;

class CompleteDayPairs {
    public int count(int[] hours) {
        int pairs = 0;
        for(int i=0; i<hours.length; i++) {
            for(int j=i+1; j<hours.length; j++) {
                if((hours[i] + hours[j]) % 24 == 0) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}


class Main {
    public static void main(String[] args) {
        CompleteDayPairs day = new CompleteDayPairs();
        int[] hours = {12,12,30,24,24};
        System.out.println(day.count(hours));
        
        int[] hours1 = {72,48,24,3};
        System.out.println(day.count(hours1));
    }
}