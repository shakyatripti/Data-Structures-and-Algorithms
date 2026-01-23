//Problem: https://leetcode.com/problems/daily-temperatures/description/





import java.io.*;
import java.util.*;

class DailyTemp {
    public int[] warmerDays(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
    
    public static void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        DailyTemp temp = new DailyTemp();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ans = temp.warmerDays(temperatures);
        temp.display(ans);
        
        int[] temperatures1 = {30,40,50,60};
        int[] ans1 = temp.warmerDays(temperatures1);
        temp.display(ans1);
        
        int[] temperatures2 = {30,60,90};
        int[] ans2 = temp.warmerDays(temperatures2);
        temp.display(ans2);
    }
}