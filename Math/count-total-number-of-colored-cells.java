//Problem: https://leetcode.com/problems/count-total-number-of-colored-cells/description/


import java.io.*;
import java.util.*;

class CountColoredCells {
    public long coloredCells(int n) {
        long ans = 0L, colors = 1L;
        if(n==1) {
            return 1;
        }
        
        while(n!=1) {
            ans+=2*colors;
            colors = colors + 2;
            n--;
        }
        ans+=colors;
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        CountColoredCells cells = new CountColoredCells();
        System.out.println(cells.coloredCells(1));
        System.out.println(cells.coloredCells(2));
        System.out.println(cells.coloredCells(3));
        System.out.println(cells.coloredCells(4));
    }
}