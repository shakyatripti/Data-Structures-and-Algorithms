//Problem: https://leetcode.com/problems/split-with-minimum-sum/description/





import java.io.*;
import java.util.*;


class SplitNum {
    public int minSum(int num) {
        ArrayList<Integer> digits = new ArrayList<>();
        while(num!=0) {
            int r = num%10;
            digits.add(r);
            num=num/10;
        }
        Collections.sort(digits);
        StringBuilder first = new StringBuilder("");
        StringBuilder second = new StringBuilder("");
        int i=0;
        while(i < digits.size()) {
            first.append(digits.get(i));
            if(i+1 < digits.size()) {
                second.append(digits.get(i+1));
            }
            i+=2;
        }
        int a = Integer.valueOf(first.toString());
        int b = Integer.valueOf(second.toString());
        return a + b;
    }
}

class Main {
    public static void main(String[] args) {
        SplitNum arr = new SplitNum();
        System.out.println(arr.minSum(4325));
        System.out.println(arr.minSum(687));
    }
}