//Problem: https://leetcode.com/problems/count-good-numbers/description/



/*Problem Statement: We need to count such numbers in which digits at even places are even and at odd places are primes(2,3,5 or 7).
    In a given number of length n, number of even indices will be (n+1)/2 and number of odd indices will be n/2. For even indices 5 possibilities 
    are there-0,2,4,6,8 and for odd indices 4 possibilties are there-2,3,5,7. Using binary exponentation we can find large powers.
*/

import java.io.*;
import java.util.*;

class CountGoodNumbers {
    int mod = (int) (1e9 + 7);
    public int countNumbers(long n) {
        long evenIndices = (n+1)/2;
        long oddIndices = n/2;
        long result = binaryExponentiation(5, evenIndices) * binaryExponentiation(4, oddIndices) % mod;
        return (int) result;
    }
    
    public long binaryExponentiation(long a, long b) {
        if(b==0) {
            return 1;
        }
        long half = binaryExponentiation(a, b/2);
        long result = (half * half)%mod;
        if(b%2==1) {
            result = (result * a)%mod;
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        CountGoodNumbers arr = new CountGoodNumbers();
        System.out.println(arr.countNumbers(1));
        System.out.println(arr.countNumbers(50));
        System.out.println(arr.countNumbers(4));
    }
}