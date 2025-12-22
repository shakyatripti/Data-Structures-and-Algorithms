//Problem: https://leetcode.com/problems/minimum-deletion-cost-to-make-all-characters-equal/description/




import java.io.*;
import java.util.*;

class MakeCharactersEqual {
    public long minCost(String s, int[] cost) {
        long ans = 0;
        long[] freq = new long[26];
        for(int i=0; i<s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            freq[ch]+= cost[i];
        }

        ArrayList<Long> arr = new ArrayList<Long>();
        for(int i=0; i<26; i++) {
            if(freq[i]!=0) {
                arr.add(freq[i]);
            }
        }
        Collections.sort(arr);
        for(int i=0; i<arr.size()-1; i++) {
            ans+=arr.get(i);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        MakeCharactersEqual str = new MakeCharactersEqual();
        int[] cost = {1,2,3,4,1,10};
        System.out.println(str.minCost("aabaac", cost));
        
        int[] cost1 = {10,5,8};
        System.out.println(str.minCost("abc", cost1));
        
        int[] cost2 = {67,67,67,67,67};
        System.out.println(str.minCost("zzzzz", cost2));
        
        int[] cost3 = {620973973,772442621,842992318,277245496};
        System.out.println(str.minCost("aaaq", cost3));
        
    }
}