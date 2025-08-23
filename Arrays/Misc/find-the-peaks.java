//Problem: https://leetcode.com/problems/find-the-peaks/description/




import java.io.*;
import java.util.*;

class FindThePeaks {
    public List<Integer> peaks(int[] mountain) {
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<mountain.length-1; i++) {
            int left = mountain[i-1], right = mountain[i+1];
            if(mountain[i] > left && mountain[i] > right) {
                res.add(i);
            }
        }
        return res;
    }
    
    public void display(List<Integer> ans) {
        if(ans.size()==0) {
            System.out.print("empty");
        }
        for(int i=0; i<ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main (String[] args) {
        FindThePeaks arr = new FindThePeaks();
        int[] mountain = {2,4,4};
        List<Integer> ans = arr.peaks(mountain);
        arr.display(ans);
        
        int[] mountain1 = {1,4,3,8,5};
        List<Integer> ans1 = arr.peaks(mountain1);
        arr.display(ans1);
    }
}