//Problem:
https://leetcode.com/problems/perfect-number/description/




import java.io.*;
import java.util.*;

class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num == 1) {
            return false;
        }

        int sum = 1;
        int half = (int) Math.sqrt(num);

        for(int i = 2; i <= half; i++) {
            if(num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }

        return sum == num;
    }
}

class Main {
    public static void main(String[] args) {
        PerfectNumber num = new PerfectNumber();

        System.out.println(num.checkPerfectNumber(28));
        System.out.println(num.checkPerfectNumber(7));
        System.out.println(num.checkPerfectNumber(1));
    }
}