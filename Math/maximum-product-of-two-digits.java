//Problem: https://leetcode.com/problems/maximum-product-of-two-digits/description




import java.io.*;
import java.util.*;

class TwoDigits {
    public int maxProduct(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(n!=0) {
            int r = n%10;
            arr.add(r);
            n=n/10;
        }
        Collections.sort(arr);
        int prod = arr.get(arr.size()-1) * arr.get(arr.size()-2);
        return prod;
    }
}

class Main {
    public static void main(String[] args) {
        TwoDigits digits = new TwoDigits();
        System.out.println(digits.maxProduct(31));
        System.out.println(digits.maxProduct(124));
        System.out.println(digits.maxProduct(22));
    }
}