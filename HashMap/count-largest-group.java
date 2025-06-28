//Problem: https://leetcode.com/problems/count-largest-group/description/




//Brute force solution
import java.io.*;
import java.util.*;

class CountLargestGroups {
    public int largestGroups(int n) {
        int largeGroups=0, maxSize=0;
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i=1; i<=n; i++) {
            int sum = i;
            if(i>9) {
                sum = digitSum(i);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
            if(maxSize < mp.get(sum)) {
                maxSize = mp.get(sum);
            }
        }
        
        for(Map.Entry entry: mp.entrySet()) {
            if((int) entry.getValue() == maxSize) {
                largeGroups++;
            }
        }
        return largeGroups;
    }
    
    public int digitSum(int n) {
        int sum = 0;
        while(n!=0) {
            int r=n%10;
            n=n/10;
            sum+=r;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        CountLargestGroups groups = new CountLargestGroups();
        System.out.println(groups.largestGroups(13));
        
        System.out.println(groups.largestGroups(2));
        
        System.out.println(groups.largestGroups(22));
        
    }
}