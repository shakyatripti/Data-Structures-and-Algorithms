//Problem: https://leetcode.com/problems/smallest-even-multiple/description/




import java.io.*;
import java.util.*;

class SmallestMultiple {
    public int isEven(int n) {
        if(n%2==0) {
            return n;
        }
        return 2*n;
    }
}

class Main {
    public static void main(String[] args) {
        SmallestMultiple multiple = new SmallestMultiple();
        System.out.println(multiple.isEven(5));
        System.out.println(multiple.isEven(6));
    }
}