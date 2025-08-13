//Problem: https://leetcode.com/problems/power-of-three/description/



import java.io.*;
import java.util.*;

class PowerOfThree {
    public boolean isPower(int n) {
        if(n<=0) {
            return false;
        }
        while(n!=1) {
            int r = n%3;
            if(r!=0) {
                return false;
            }
            n=n/3;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        PowerOfThree num = new PowerOfThree();
        System.out.println(num.isPower(9));
        System.out.println(num.isPower(0));
        System.out.println(num.isPower(-1));
        System.out.println(num.isPower(27));
        System.out.println(num.isPower(-15));
    }
}