//Problem: https://leetcode.com/problems/closest-prime-numbers-in-range/

import java.io.*;
import java.util.*;

class ClosestPrimes {
    public int[] closestPrimeInRange(int left, int right) {
        boolean[] primes = new boolean[right + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for(int p=2; p*p<=right; p++) {
            if(primes[p]) {
                for(int j=p*p; j<=right; j+=p) {
                    primes[j] = false;
                }
            }
        }
        ArrayList<Integer> primeNums = new ArrayList<Integer>();
        for(int i=left; i<=right; i++) {
            if(primes[i]) {
                primeNums.add(i);
            }
        }
        
        if(primeNums.size() < 2) {
            return new int[]{-1,-1};
        }
        
        int diff = Integer.MAX_VALUE;
        int[] closestPair = new int[2];
        for(int i=1; i<primeNums.size(); i++) {
            int gap = primeNums.get(i) - primeNums.get(i-1);
            if(gap < diff) {
                diff = gap;
                closestPair[0] = primeNums.get(i-1);
                closestPair[1] = primeNums.get(i);
            }
        }
        return closestPair;
    }
}

class Main {
    public static void main(String[] args) {
        ClosestPrimes primes = new ClosestPrimes();
        int[] ans = primes.closestPrimeInRange(1,10);
        System.out.println(ans[0] + " " + ans[1]);
        
        int[] ans2 = primes.closestPrimeInRange(4,6);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}