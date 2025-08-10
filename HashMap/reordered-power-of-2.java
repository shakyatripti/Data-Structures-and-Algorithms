//Problem: https://leetcode.com/problems/reordered-power-of-2/description/




import java.io.*;
import java.util.*;

class ReorderedPower {
    public boolean reorderedPowerOf2(int n) {
        if(n==1) {
           return true;
        }
        for(int i=0; i<30; i++) {
            int m = (int) Math.pow(2,i);
            if(isSame(n,m)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isSame(int n, int m) {
        int[] freq = new int[10];
        while(n!=0) {
            int r=n%10;
            freq[r]++;
            n=n/10;
        }
        int[] freq2 = new int[10];
        while(m!=0) {
            int r=m%10;
            freq2[r]++;
            m=m/10;
        }
        for(int i=0; i<10; i++) {
            if(freq[i]!=freq2[i]) {
                return false;
            }
        }
        return true;
    }
}


class Main {
    public static void main(String[] args) {
        ReorderedPower obj = new ReorderedPower();
        System.out.println(obj.reorderedPowerOf2(1));
        System.out.println(obj.reorderedPowerOf2(10));
        System.out.println(obj.reorderedPowerOf2(61));
        System.out.println(obj.reorderedPowerOf2(2140));
    }
}