//Problem: https://leetcode.com/problems/self-dividing-numbers/description/




import java.io.*;
import java.util.*;

class SelfDividingNumbers {
    public List<Integer> isValid(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i=left; i<=right; i++) {
            if(canDivide(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean canDivide(int n) {
        int m=n;
        while(n!=0) {
            int r = n%10;
            if(r==0 || m%r!=0) {
                return false;
            }
            n=n/10;
        }
        return true;
    }
    
    public void display(List<Integer> ans) {
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        SelfDividingNumbers num = new SelfDividingNumbers();
        List<Integer> ans = num.isValid(1, 22);
        num.display(ans);
        
        List<Integer> ans1 = num.isValid(47, 85);
        num.display(ans1);
    }
}