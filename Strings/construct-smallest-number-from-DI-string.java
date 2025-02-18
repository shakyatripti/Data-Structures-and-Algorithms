//Problem: https://leetcode.com/problems/construct-smallest-number-from-di-string/description/


import java.util.*;
import java.io.*;

class ConstructNumberFromDIString {
    public String smallestNumber(String pattern) {
        StringBuilder ans = new StringBuilder();
        int n = pattern.length(), index = 0;
        int[] stack = new int[n+1];
        for(int i=0; i<=n; i++) {
            stack[index++] = i + 1;
            if(i==n || pattern.charAt(i)=='I') {
                while(index > 0) {
                    ans.append(stack[--index]);
                }
            }
        }
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        ConstructNumberFromDIString str = new ConstructNumberFromDIString();
        System.out.println(str.smallestNumber("IIIDIDDD"));
        System.out.println(str.smallestNumber("DDD"));
    }
}


