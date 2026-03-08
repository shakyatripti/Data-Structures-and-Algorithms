//Problem: https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/description/




import java.io.*;
import java.util.*;

class TwoEqualIntegers {
    public int minChanges(int n, int k) {
        int count = 0, count1 = 0;
        StringBuilder s1 = convertToBinary(n);
        StringBuilder s2 = convertToBinary(k);
        int p = s1.toString().length(), q = s2.toString().length();
        
        while (p < q) {
            s1.append('0');
            p++;
        }

        while (q < p) {
            s2.append('0');
            q++;
        }
        String str1 = s1.reverse().toString();
        String str2 = s2.reverse().toString();

        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i)=='1' && str2.charAt(i)=='0') {
                count++;
            }

            if(str1.charAt(i)=='0' && str2.charAt(i)=='1') {
                count1++;
            }

        }
        return count1==0 ? count : -1;
    }

    public StringBuilder convertToBinary(int n) {
        StringBuilder str = new StringBuilder("");
        while(n!=0) {
            int r = n%2;
            str.append(r);
            n=n/2;
        }
        return str;
    }
}


class Main {
    public static void main(String[] args) {
        TwoEqualIntegers num = new TwoEqualIntegers();
        System.out.println(num.minChanges(13, 4));
        System.out.println(num.minChanges(21, 21));
        System.out.println(num.minChanges(14, 13));
        System.out.println(num.minChanges(2, 47));
    }
}