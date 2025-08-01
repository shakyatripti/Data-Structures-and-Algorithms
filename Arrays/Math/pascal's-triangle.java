//Problem: https://leetcode.com/problems/pascals-triangle/description/





import java.io.*;
import java.util.*;

class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> rows = new ArrayList<Integer>(Arrays.asList(1));
        ans.add(rows);
        for(int i=1; i<numRows; i++) {
            List<Integer> nextRows = new ArrayList<Integer>();
            List<Integer> prevRow = ans.get(i-1);
            nextRows.add(1);
            for(int j=1; j<prevRow.size(); j++) {
                int left = prevRow.get(j-1);
                int right = prevRow.get(j);
                nextRows.add(left+right);
            }
            nextRows.add(1);
            ans.add(nextRows);
        }
        return ans;
    }
    
    public void display(List<List<Integer>> ans) {
        for(int i=0; i<ans.size(); i++) {
            for(int j=0; j<ans.get(i).size(); j++)  {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}


class Main {
    public static void main(String[] args) {
        PascalTriangle triangle = new PascalTriangle();
        List<List<Integer>> ans = triangle.generate(5);
        triangle.display(ans);
        
        List<List<Integer>> ans1 = triangle.generate(1);
        triangle.display(ans1);
    }
}