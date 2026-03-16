//Problem: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/description/





import java.io.*;
import java.util.*;

class FindDifference {
    public int subtractProductAndSum(int n) {
        int sum = 0, prod = 1;
        while(n!=0) {
            int r = n%10;
            sum+=r;
            prod*=r;
            n = n/10;
        }
        return prod - sum;
    }
}

class Main {
    public static void main(String[] args) {
        FindDifference arr = new FindDifference();
        System.out.println(arr.subtractProductAndSum(234));
        System.out.println(arr.subtractProductAndSum(4421));
    }
}