//Problem: https://leetcode.com/problems/find-the-k-beauty-of-a-number/description/





import java.io.*;
import java.util.*;


class KBeauty {
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        String str = String.valueOf(num);
        for(int i=0; i<=str.length()-k; i++) {
            String substr = str.substring(i, i+k);
            int val = Integer.valueOf(substr);
            if(val!=0 && num%val==0) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        KBeauty str = new KBeauty();
        System.out.println(str.divisorSubstrings(240, 2));
        System.out.println(str.divisorSubstrings(430043, 2));
    }
}