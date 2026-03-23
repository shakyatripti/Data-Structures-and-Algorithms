//Problem: https://leetcode.com/problems/count-commas-in-range/description/




import java.io.*;
import java.util.*;

class CommasInRange {
    public int count(int n) {
        if(n > 999) {
            return n-999;
        }
        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        CommasInRange num = new CommasInRange();
        System.out.println(num.count(1002));
        System.out.println(num.count(998));
    }
}