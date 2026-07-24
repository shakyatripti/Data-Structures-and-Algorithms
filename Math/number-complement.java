//Problem: https://leetcode.com/problems/number-complement/description/





import java.io.*;
import java.util.*;


class NumberComplement {
    public int find (int num) {
        StringBuilder str = new StringBuilder("");
        while(num!=0) {
            int r = num%2;
            num = num/2;
            str.append(1-r);
        }
        String rev = str.toString();
        int k=0, ans=0;
        for(char ch: rev.toCharArray()) {
            ans+=Math.pow(2, k) * (ch-'0');
            k++;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        NumberComplement n = new NumberComplement();
        System.out.println(n.find(5));
        System.out.println(n.find(1));
        System.out.println(n.find(8));
    }
}