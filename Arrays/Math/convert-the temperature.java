//Problem: https://leetcode.com/problems/convert-the-temperature/description/


import java.io.*;
import java.util.*;

class ConvertTemperature {
    public double[] conversion(double celsius) {
        double[] ans = new double[2];
        ans[0] = celsius + 273.15;
        ans[1] = celsius * 1.80 + 32.00;
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ConvertTemperature temp = new ConvertTemperature();
        double[] ans = temp.conversion(36.50);
        System.out.println(ans[0] + " " + ans[1]);
        double[] ans1 = temp.conversion(122.11);
        System.out.println(ans1[0] + " " + ans1[1]);
    }
}