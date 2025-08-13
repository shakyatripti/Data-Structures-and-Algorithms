//Problem: https://leetcode.com/problems/power-of-two/description/



import java.io.*;
import java.util.*;

class PowerOfTwo {
    public boolean isValidPower(int n) {
        if(n<=0) {
            return false;
        }
        while(n!=1) {
            int r = n%2;
            if(r!=0) {
                return false;
            }
            n=n/2;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        PowerOfTwo obj = new PowerOfTwo();
        System.out.println(obj.isValidPower(4));
        System.out.println(obj.isValidPower(-16));
        System.out.println(obj.isValidPower(6));
        System.out.println(obj.isValidPower(1));
    }
}