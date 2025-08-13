//Problem: https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/description/



import java.io.*;
import java.util.*;

class DivideCircle {
    public int numberOfCuts(int n) {
        if(n==1) {
            return 0;
        }
        if(n%2==0) {
            return n/2;
        }
        return n;
    }
}

class Main {
    public static void main(String[] args) {
        DivideCircle circle = new DivideCircle();
        System.out.println(circle.numberOfCuts(4));
        System.out.println(circle.numberOfCuts(15));
        System.out.println(circle.numberOfCuts(1));
        System.out.println(circle.numberOfCuts(8));
        System.out.println(circle.numberOfCuts(6));
    }
}