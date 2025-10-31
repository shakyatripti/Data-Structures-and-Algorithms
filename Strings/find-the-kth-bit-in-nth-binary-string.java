//Problem: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/





import java.io.*;
import java.util.*;

class BinaryString {
    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder("0");
        while(n!=1) {
            StringBuilder prev = new StringBuilder();
            for(int i=0; i<str.length(); i++) {
                char ch = str.charAt(i);
                if(ch=='1') {
                    prev.append('0');
                } else {
                    prev.append('1');
                }
            }
            prev.reverse();
            str.append("1");
            str.append(prev);
            n--;
        }
        return str.charAt(k-1);
    }
}

class Main {
    public static void main(String[] args) {
        BinaryString str = new BinaryString();
        System.out.println(str.findKthBit(3, 1));
        System.out.println(str.findKthBit(4, 11));
    }
}