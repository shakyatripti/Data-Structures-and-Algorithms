//Problem: https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/description/


import java.util.*;
import java.io.*;

class LexicographicallyLargestSequence {
    public int[] largestValidSequence(int n) {
        int[] sequence = new int[2*n-1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);
        Arrays.fill(sequence, 0);
        backtrack(sequence, visited, 0, n);
        return sequence;
    }
    
    public boolean backtrack(int[] sequence, boolean[] visited, int index, int n) {
        while(index < sequence.length && sequence[index]!=0) {
            index++;
        }
        if(index == sequence.length) {
            return true;
        }
        for(int i=n; i>=1; i--) {
            if(visited[i]) {
                continue;
            }
            
            if(i==1) {
                sequence[index] = 1;
                visited[1] = true;
                if(backtrack(sequence, visited, index + 1, n)) {
                    return true;
                }
                sequence[index] = 0;
                visited[1] = false;
            }
            
            if(i > 1) {
                if(index + i < sequence.length && sequence[index + i]==0) {
                    sequence[index] = i;
                    sequence[index + i] = i;
                    visited[i] = true;
                    if(backtrack(sequence, visited, index + 1, n)) {
                        return true;
                    }
                    sequence[index] = 0;
                    sequence[index + i] = 0;
                    visited[i] = false;
                }
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        LexicographicallyLargestSequence sequence = new LexicographicallyLargestSequence();
        int[] result = sequence.largestValidSequence(5);
        int[] result2 = sequence.largestValidSequence(3);
        for(int i=0; i< result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("\n");
        for(int i=0; i< result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
    }
}