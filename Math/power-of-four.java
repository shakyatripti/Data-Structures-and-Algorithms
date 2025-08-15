//Problem: https://leetcode.com/problems/power-of-four/description/



import java.io.*;
import java.util.*;

class PowerOfFour {
    public boolean isPower(int n) {
        if(n<=0) {
            return false;
        }
        while(n!=1) {
            int r = n%4;
            if(r!=0) {
                return false;
            }
            n=n/4;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        PowerOfFour num = new PowerOfFour();
        System.out.println(num.isPower(16));
        System.out.println(num.isPower(5));
        System.out.println(num.isPower(1));
        System.out.println(num.isPower(-64));
    }
}