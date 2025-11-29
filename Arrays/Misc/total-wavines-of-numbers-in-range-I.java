//Problem: https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/





import java.io.*;
import java.util.*;


class TotalWaviness {
    public int calculate(int num1, int num2) {
        int sum = 0;
        for(int i=num1; i<=num2; i++) {
            sum+=countPeakValley(i);
        }
        return sum;
    }

    public int countPeakValley(int n) {
        int total = 0;
        String str = String.valueOf(n);
        for(int i=1; i<str.length()-1; i++) {
            int prev = str.charAt(i-1) - '0';
            int next = str.charAt(i+1) - '0';
            int curr = str.charAt(i) - '0';
            if((curr > prev && curr > next) || (curr < prev && curr < next)) {
                total++;
            }
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        TotalWaviness num = new TotalWaviness();
        System.out.println(num.calculate(120, 130));
        System.out.println(num.calculate(198, 202));
        System.out.println(num.calculate(4848, 4848));
    }
}