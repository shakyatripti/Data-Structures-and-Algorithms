//Problem: https://leetcode.com/problems/sort-integers-by-the-power-value/description/




import java.io.*;
import java.util.*;

class PowerValue {
    public int getKth(int lo, int hi, int k) {
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i=lo; i<=hi; i++) {
            int power = calculatePower(i);
            ans.add(new int[]{power, i});
        }
        Collections.sort(ans, (x,y)-> {
            if(x[0]==y[0]) {
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(x[0], y[0]);
        });
        return ans.get(k-1)[1];
    }

    public int calculatePower(int n) {
        int steps = 0;
        while(n!=1) {
            if(n%2==0) {
                n=n/2;
            } else {
                n=3*n + 1;
            }
            steps++;
        }
        return steps;
    }
}

class Main {
    public static void main(String[] args) {
        PowerValue num = new PowerValue();
        System.out.println(num.getKth(12, 15, 2));
        System.out.println(num.getKth(7, 11, 4));
    }
}