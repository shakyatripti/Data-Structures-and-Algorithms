//Problem: https://leetcode.com/problems/diagonal-traverse/description/




//Brute force solution
import java.io.*;
import java.util.*;

class DiagonalTraverse {
    public int[] findOrder(int[][] mat) {
        int m=mat.length, n=mat[0].length, k=0, flag=0, size=0;
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                size++;
                if(mp.containsKey(i+j)) {
                    List<Integer> arr = mp.get(i+j);
                    arr.add(mat[i][j]);
                    mp.put(i+j, arr);
                } else {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(mat[i][j]);
                    mp.put(i+j, arr);
                }
                
            }
        }
        int[] ans = new int[size];
        for(Map.Entry<Integer, List<Integer>> entry: mp.entrySet()) {
            List<Integer> arr = entry.getValue();
            if(flag==0) {
                for(int i=arr.size()-1; i>=0; i--) {
                    ans[k]=arr.get(i);
                    k++;
                }
                flag=1;
            }
            else {
                for(int i=0; i<arr.size(); i++) {
                    ans[k]=arr.get(i);
                    k++;
                }
                flag=0;
            }
        }
        return ans;
    }
    
    public void display(int[] ans) {
        if(ans.length==0) {
            System.out.print("empty");
        }
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}


class Main {
    public static void main(String[] args) {
        DiagonalTraverse diagonal = new DiagonalTraverse();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ans = diagonal.findOrder(mat);
        diagonal.display(ans);
        
        int[][] mat1 = {{3,4},{6,7}};
        int[] ans1 = diagonal.findOrder(mat1);
        diagonal.display(ans1);
        
        int[][] mat2 = {{6,9}};
        int[] ans2 = diagonal.findOrder(mat2);
        diagonal.display(ans2);
        
    }
}