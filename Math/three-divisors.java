//Problem: https://leetcode.com/problems/three-divisors/description/





import java.io.*;
import java.util.*;


class ThreeDivisors {
    public boolean isThree(int n) {
        int count=0;
        for(int i=1; i<=n; i++) {
            if(n%i==0) {
                count++;
            }
            if(count > 3) {
                return false;
            }
        }

        if(count==3) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        ThreeDivisors div = new ThreeDivisors();
        System.out.println(div.isThree(2));
        System.out.println(div.isThree(4));
        System.out.println(div.isThree(10000));
    }
}