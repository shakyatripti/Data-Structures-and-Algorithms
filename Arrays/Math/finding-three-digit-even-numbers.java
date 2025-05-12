//Problem: https://leetcode.com/problems/finding-3-digit-even-numbers/description/




import java.io.*;
import java.util.*;

class FindingThreeDigitEvenNum {
    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] freq = new int[10];
        for(int i=0; i<digits.length; i++) {
            freq[digits[i]]++;
        }
        for(int i=100; i<=999; i++) {
            int[] count = new int[10];
            int flag=0, n=i;
            while(n!=0) {
                int r = n%10;
                count[r]++;
                if(freq[r] < count[r]) {
                   flag = 1;
                }
                n=n/10;
            }
            if(flag==0 && i%2==0) {
                arr.add(i);
            }
        }

        int[] ans = new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
           ans[i] = arr.get(i);
        }
        return ans;
    }
    
    public void display(int[] ans) {
        if(ans.length==0) {
            System.out.print("Empty");
        }
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] +  " ");
        }
        System.out.print("\n");
    }
}

class Main {
    public static void main(String[] args) {
        FindingThreeDigitEvenNum num = new FindingThreeDigitEvenNum();
        int[] digits = {2,1,3,0};
        int[] ans = num.findEvenNumbers(digits);
        num.display(ans);
        
        int[] digits1 = {2,2,8,8,2};
        int[] ans1 = num.findEvenNumbers(digits1);
        num.display(ans1);
        
        int[] digits2 = {3,7,5};
        int[] ans2 = num.findEvenNumbers(digits2);
        num.display(ans2);
    }
}