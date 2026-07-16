//Problem: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/




import java.io.*;
import java.util.*;

class AverageSalary {
    public double calcAverage(int[] salary) {
        Arrays.sort(salary);
        int n=salary.length-2;
        double sum=0;
        for(int i=1; i<salary.length-1; i++) {
            sum+=salary[i];
        }
        return sum/n;
    }
}

class Main {
    public static void main(String[] args) {
        AverageSalary employee = new AverageSalary();
        int[] salary = {4000,3000,1000,2000};
        System.out.println(employee.calcAverage(salary));
        
        int[] salary1 = {1000,2000,3000};
        System.out.println(employee.calcAverage(salary1));
        
        int[] salary2 = {48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
        System.out.println(employee.calcAverage(salary2));
    }
}