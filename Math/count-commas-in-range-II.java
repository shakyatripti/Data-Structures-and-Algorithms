//Problem: https://leetcode.com/problems/count-commas-in-range-ii/description/




import java.io.*;
import java.util.*;


class CommasInRangeII {
    public long countTotal(long n) {
        long total = 0;
        if(n < 1000) {
            return 0;
        } if(n >= 1000) {
            total+= n - 1000 + 1;
        } if(n >= 1000000) {
            total+= n - 1000000 + 1;
        } if(n >= 1000000000) {
            total+= n - 1000000000 + 1;
        } if(n >= 1000000000000L) {
            total+= n - 1000000000000L + 1;
        } if(n >= 1000000000000000L) {
            total+= n - 1000000000000000L + 1;
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        CommasInRangeII num = new CommasInRangeII();
        System.out.println(num.countTotal(1002));
        System.out.println(num.countTotal(998));
        System.out.println(num.countTotal(1004590));
        System.out.println(num.countTotal(1000000000000000L));
    }
}