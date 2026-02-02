//Problem: https://leetcode.com/problems/count-monobit-integers/description/





import java.io.*;
import java.util.*;

class MonobitIntegers {
    public int countMonobit(int n) {
        int count = 1;
        for(int i=1; i<=n; i++) {
            if(isSameBits(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isSameBits(int n) {
        Set<Integer> st = new HashSet<>();
        while(n!=0) {
            int r = n%2;
            n=n/2;
            st.add(r);
        }
        if(st.size()==1) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        MonobitIntegers arr = new MonobitIntegers();
        System.out.println(arr.countMonobit(1));
        System.out.println(arr.countMonobit(4));
    }
}