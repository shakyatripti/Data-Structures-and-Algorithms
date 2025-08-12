//Problem: https://leetcode.com/problems/harshad-number/description/




import java.io.*;
import java.util.*;

class HarshadNumber {
    public int sumOfTheDigits(int x) {
        int sum = 0, n = x;
        while(n!=0) {
            int r = n%10;
            sum+=r;
            n = n/10;
        }
        if(x%sum==0) {
            return sum;
        }
        return -1;
    }
}


class Main {
    public static void main(String[] args) {
        HarshadNumber num = new HarshadNumber();
        System.out.println(num.sumOfTheDigits(18));
        System.out.println(num.sumOfTheDigits(23));
    }
}