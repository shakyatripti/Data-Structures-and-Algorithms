//Problem: https://leetcode.com/problems/check-if-the-number-is-fascinating/description/




import java.io.*;
import java.util.*;

class FascinatingNumber {
    public boolean isFascinating(int n) {
        HashSet<Integer> st = new HashSet<>();
        String ans = "";
        ans+=String.valueOf(n);
        ans+=String.valueOf(2*n);
        ans+=String.valueOf(3*n);
        for(char ch: ans.toCharArray()) {
            int val = ch-'0';
            if(val==0 || st.contains(val)) {
                return false;
            } else {
                st.add(val);
            }
        }
        if(st.size()==9) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        FascinatingNumber num = new FascinatingNumber();
        System.out.println(num.isFascinating(783));
        System.out.println(num.isFascinating(100));
        System.out.println(num.isFascinating(192));
        System.out.println(num.isFascinating(999));
    }
}