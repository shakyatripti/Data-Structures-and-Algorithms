//Problem: https://leetcode.com/problems/number-of-employees-who-met-the-target/description/




import java.io.*;
import java.util.*;

class NumberOfEmployees {
    public int metTarget(int[] hours, int target) {
        int count = 0;
        for(int i=0; i<hours.length; i++) {
            if(hours[i]>=target) {
                count++;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        NumberOfEmployees employees = new NumberOfEmployees();
        int[] hours = {0,1,2,3,4};
        System.out.println(employees.metTarget(hours, 2));
        
        int[] hours1 = {5,1,4,2,2};
        System.out.println(employees.metTarget(hours1, 6));
    }
}