//Problem: https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/description/





//Brute Force solution

import java.io.*;
import java.util.*;

class FindTheStudent {
    public int chalkReplacer(int[] chalk, int k) {
        int curr = chalk[0], i=0;
        while(curr <= k) {
            k-=curr;
            i++;
            if(i==chalk.length) {
               i=0;
            }
            curr = chalk[i];
        }
        return i;
    }
}

class Main {
    public static void main(String[] args) {
        FindTheStudent student = new FindTheStudent();
        int[] chalk = {5,1,5};
        System.out.println(student.chalkReplacer(chalk, 22));
        int[] chalk1 = {3,4,1,2};
        System.out.println(student.chalkReplacer(chalk1, 25));
    }
}