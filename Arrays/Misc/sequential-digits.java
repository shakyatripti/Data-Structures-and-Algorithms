//Problem: https://leetcode.com/problems/sequential-digits/description/



import java.io.*;
import java.util.*;


class SequentialDigits {
    public List<Integer> sortedList(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList(Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789));

        for(int i=0; i<arr.size(); i++) {
            int val = arr.get(i);
            if(val>=low && val<=high) {
                ans.add(val);
            }
        }
        return ans;
    }
    
    public void display(List<Integer> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        SequentialDigits digits = new SequentialDigits();
        List<Integer> ans = digits.sortedList(100, 300);
        digits.display(ans);
        
        List<Integer> ans1 = digits.sortedList(1000, 13000);
        digits.display(ans1);
        
        List<Integer> ans2 = digits.sortedList(10, 1000000000);
        digits.display(ans2);
    }
}