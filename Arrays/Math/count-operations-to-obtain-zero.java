//Problem: https://leetcode.com/problems/count-operations-to-obtain-zero/description/



import java.io.*;
import java.util.*;

class ObtainZero {
    public int countOperations(int num1, int num2) {
        int operations = 0;
        while(num1!=0 && num2!=0) {
            if(num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            operations++;
        }
        return operations;
    }
}

class Main {
    public static void main(String[] args) {
        ObtainZero arr = new ObtainZero();
        System.out.println(arr.countOperations(2,3));
        System.out.println(arr.countOperations(10,10));
    }
}