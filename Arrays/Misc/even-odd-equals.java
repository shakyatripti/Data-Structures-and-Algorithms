/*Problem: (Asked in Visa Coding test) Given an array, your task is to print "Even" in case number of even integers 
    are greater than odd integers, print "Odd" in case number of odd integers is greater than odd and print "Equals" 
    in case both even and odd are equals.
*/


import java.io.*;
import java.util.*;

class EvenOddEquals {
    public String printEvenOddEquals(int[] nums) {
        int odd=0, even=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==0) {
                even++;
            } else {
                odd++;
            }
        }
        
        if(even > odd) {
            return "Even";
        } else if(odd > even) {
            return "Odd";
        }
        return "Equals";
    }
}

class Main {
    public static void main(String[] args) {
        EvenOddEquals obj = new EvenOddEquals();
        int[] nums = {12, 13, 1, 29};
        System.out.println(obj.printEvenOdd(nums));
        
        int[] nums2 = {100, 76, 5, 17, 20};
        System.out.println(obj.printEvenOdd(nums2));
        
        int[] nums3 = {2, 19};
        System.out.println(obj.printEvenOdd(nums3));
        
    }
}