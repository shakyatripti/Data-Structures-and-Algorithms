//Problem: https://leetcode.com/problems/optimal-partition-of-string/description/





import java.io.*;
import java.util.*;

class OptimalPartition {
    public int partitionString(String s) {
        int count = 0;
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            int val = ch - 'a';
            if(freq[val] > 0) {
                Arrays.fill(freq, 0);
                count++;
            }
            freq[val]++;
        }
        return count + 1;
    }
}

class Main {
    public static void main(String[] args) {
        OptimalPartition str = new OptimalPartition();
        System.out.println(str.partitionString("abacaba"));
        System.out.println(str.partitionString("ssssss"));
        System.out.println(str.partitionString("p"));
    }
}