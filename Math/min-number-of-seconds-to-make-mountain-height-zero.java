//Problem: https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/description/



import java.io.*;
import java.util.*;

class ReduceToZero {
    public int numberOfSteps(int num) {
        int steps = 0;
        while(num!=0) {
            steps++;
            if(num%2==0) {
                num=num/2;
            } else {
                num--;
            }
        }
        return steps;
    }
}


class Main {
    public static void main(String[] args) {
        ReduceToZero arr = new ReduceToZero();
        System.out.println(arr.numberOfSteps(14));
        System.out.println(arr.numberOfSteps(8));
        System.out.println(arr.numberOfSteps(123));
    }
}
