//Problem: https://leetcode.com/problems/find-the-pivot-integer/description/




import java.io.*;
import java.util.*;

class FindPivot {
    public int pivotInteger(int n) {
        int sum = 0, left = 0, right = 0, x=1;
        for(int i=1; i<=n; i++) {
            sum+=i;
        }
        right = sum;
        left = x;
        while(right>=0) {
            right-=(x-1);
            if(left==right) {
                return x;
            }
            x++;
            left+=x;
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        FindPivot num = new FindPivot();
        System.out.println(num.pivotInteger(8));
        System.out.println(num.pivotInteger(4));
        System.out.println(num.pivotInteger(1));
    }
}