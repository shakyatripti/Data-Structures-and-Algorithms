//Problem: https://leetcode.com/problems/remove-zeros-in-decimal-representation/description/




import java.io.*;
import java.util.*;

class DecimalRepresentation {
    public long removeZeros(long n) {
        StringBuilder ans = new StringBuilder();
        while(n!=0) {
            long r=n%10;
            if(r!=0) {
                ans.append(r);
            }
            n=n/10;
        }
        ans.reverse();
        return Long.valueOf(ans.toString());
    }
}

class Main {
    public static void main(String[] args) {
        DecimalRepresentation decimal = new DecimalRepresentation();
        System.out.println(decimal.removeZeros(1020030));
        System.out.println(decimal.removeZeros(1));
    }
}