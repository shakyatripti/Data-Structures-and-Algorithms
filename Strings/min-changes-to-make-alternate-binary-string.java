//Problem: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/description/




import java.io.*;
import java.util.*;

class AlternatingBinaryString {
    public int minOperations(String s) {
        int n=s.length(), c1=0, c2=0;
        String s1 = formAlternates(n, 0);
        String s2 = formAlternates(n, 1);
        for(int i=0; i<n; i++) {
            if(s1.charAt(i)!= s.charAt(i)) {
                c1++;
            }
            if(s2.charAt(i)!= s.charAt(i)) {
                c2++;
            }

        }
        return Math.min(c1, c2);
    }

    public String formAlternates(int n, int flag) {
        String ans = "";
        while(n!=0) {
            if(flag==1) {
                ans+="0";
            } else {
                ans+="1";
            }
            flag=1-flag;
            n--;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        AlternatingBinaryString binary = new AlternatingBinaryString();
        System.out.println(binary.minOperations("0100"));
        System.out.println(binary.minOperations("10"));
        System.out.println(binary.minOperations("1111"));
    }
}