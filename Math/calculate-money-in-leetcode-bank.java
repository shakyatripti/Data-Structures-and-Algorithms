//Problem: https://leetcode.com/problems/calculate-money-in-leetcode-bank/description/





import java.io.*;
import java.util.*;


class LeetcodeBank {
    public int totalMoney(int n) {
        int total = 0, c1 = 0;
        for(int i=1; i<=n; i++) {
            for(int j=i; j<7+i; j++) {
                if(c1!=n) {
                    total+=j;
                    c1++;
                } else {
                    return total;
                }
            }
        }
        return total;
    }
}

class Main {
    public static void main(String[] args) {
        LeetcodeBank bank = new LeetcodeBank();
        System.out.println(bank.totalMoney(4));
        System.out.println(bank.totalMoney(10));
        System.out.println(bank.totalMoney(20));
    }
}