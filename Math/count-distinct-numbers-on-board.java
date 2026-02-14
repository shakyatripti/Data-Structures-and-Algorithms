//Problem: https://leetcode.com/problems/count-distinct-numbers-on-board/description/




//Brute-force solution

import java.io.*;
import java.util.*;

class CountInBoard {
    public int distinctIntegers(int n) {
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> ans = new HashSet<>();
        st.add(n);
        ans.add(n);
        while(!st.isEmpty()) {
            for(int i=0; i<st.size(); i++) {
                int val = st.pop();
                for(int j=1; j<=val; j++) {
                    if(val%j==1) {
                        st.add(j);
                        ans.add(j);
                    }
                }
            }
        }
        return ans.size();
    }
}

class Main {
    public static void main(String[] args) {
        CountInBoard board = new CountInBoard();
        System.out.println(board.distinctIntegers(5));
        System.out.println(board.distinctIntegers(3));
    }
}





//Optimal solution

import java.io.*;
import java.util.*;

class CountInBoard {
    public int distinctIntegers(int n) {
        if(n < 2) {
            return 1;
        }
        return n-1;
    }
}

class Main {
    public static void main(String[] args) {
        CountInBoard board = new CountInBoard();
        System.out.println(board.distinctIntegers(5));
        System.out.println(board.distinctIntegers(3));
    }
}