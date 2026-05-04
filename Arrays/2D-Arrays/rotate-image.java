//Problem: https://leetcode.com/problems/rotate-image/description/




import java.io.*;
import java.util.*;

class RotateImage {
    public void rotation(int[][] matrix) {
        int n = matrix.length;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) {
            ArrayList<Integer> num = new ArrayList<>();
            for(int j=0; j<n; j++) {
                num.add(matrix[j][i]);
            }
            Collections.reverse(num);
            arr.add(num);
        }

        for(int i=0; i<arr.size(); i++) {
            for(int j=0; j<arr.get(i).size(); j++) {
                matrix[i][j] = arr.get(i).get(j);
            }
        }
    }
    
    public void display(int[][] ans) {
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<ans.length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        RotateImage image = new RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        image.rotation(matrix);
        image.display(matrix);
        
        int[][] matrix1 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        image.rotation(matrix1);
        image.display(matrix1);
    }
}