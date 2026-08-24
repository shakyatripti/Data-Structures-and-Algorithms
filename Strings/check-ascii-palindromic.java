//Problem: https://leetcode.com/problems/check-ascii-palindromic/description/




import java.io.*;
import java.util.*;


class BinaryString {
    public boolean isASCIIPalindromic(String s) {
        StringBuilder ans = new StringBuilder("");
        for(char ch: s.toCharArray()) {
            ans.append(binaryRep(ch - 0));
        }
        String org = ans.toString();
        String rev = ans.reverse().toString();
        if(rev.equals(org)) {
            return true;
        }
        return false;
    }

    public String binaryRep(int n) {
        StringBuilder str = new StringBuilder("");
        while(n!=0) {
            int r = n%2;
            str.append(r);
            n = n/2;
        }

        while(str.length()!=8) {
            str.append("0");
        }
        return str.reverse().toString();
    }
}


class Main {
    public static void main(String[] args) {
        BinaryString str = new BinaryString();
        System.out.println(str.isASCIIPalindromic("ff"));
        System.out.println(str.isASCIIPalindromic("leet"));
    }
}