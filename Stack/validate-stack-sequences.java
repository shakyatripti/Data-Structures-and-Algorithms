//Problem: https://leetcode.com/problems/validate-stack-sequences/description/




import java.io.*;
import java.util.*;

class StackSequences {
    public boolean validate(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int n=pushed.length, l=0, r=0;
        while(l<=n && r <= n) {
            if(!st.isEmpty() && st.peek()==popped[r]) {
                st.pop();
                r++;
            } else {
                if(l < n) {
                    st.push(pushed[l]);
                }
                l++;
            }
        }
        if(r < n) {
            return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        StackSequences stack = new StackSequences();
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(stack.validate(pushed, popped));
        
        int[] pushed1 = {1,2,3,4,5};
        int[] popped1 = {4,3,5,1,2};
        System.out.println(stack.validate(pushed1, popped1));
        
        int[] pushed2 = {2,1,0};
        int[] popped2 = {1,2,0};
        System.out.println(stack.validate(pushed2, popped2));
    }
}