//Problem: https://leetcode.com/problems/find-the-least-frequent-digit/description/




import java.io.*;
import java.util.*;

class LeastFrequentDigit {
    public int findDigit(int n) {
        int result = Integer.MAX_VALUE, digit = Integer.MAX_VALUE;
        int[] freq = new int[10];
        String ans = String.valueOf(n);
        for(char ch: ans.toCharArray()) {
            int num = ch - '0';
            freq[num]++;
        }
        for(int i=0; i<10; i++) {
            if(result==freq[i]) {
                digit = Math.min(i, digit);
            }
            else if(freq[i]!= 0 && result > freq[i]) {
                result = freq[i];
                digit = i;
            }
        }
        return digit;
    }
}

class Main {
    public static void main(String[] args) {
        LeastFrequentDigit num = new LeastFrequentDigit();
        System.out.println(num.findDigit(1553322));
        System.out.println(num.findDigit(723344511));
    }
}