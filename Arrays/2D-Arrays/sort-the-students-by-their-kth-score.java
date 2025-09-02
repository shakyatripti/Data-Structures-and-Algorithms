//Problem: https://leetcode.com/problems/sort-the-students-by-their-kth-score/description/





import java.io.*;
import java.util.*;

class SortTheStudents {
	public int[][] kthScore(int[][] score, int k) {
        ArrayList<int[]> arr = new ArrayList<>();
        int m=score.length, n=score[0].length, idx=0;
        for(int i=0; i<m; i++) {
            int[] ans = new int[2];
            ans[0] = score[i][k];
            ans[1] = i;
            arr.add(ans);
        }
        
        Collections.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] result = new int[m][n];
        for(int j=arr.size()-1; j>=0; j--) {
            int index = arr.get(j)[1];
            for(int i=0; i<n; i++) {
                result[idx][i] = score[index][i];
            }
            idx++;
        }
        return result;
    }
    
    public void display(int[][] score) {
        int m=score.length, n=score[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(score[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }
}

class Main {
	public static void main(String[] args) {
		SortTheStudents students = new SortTheStudents();
		int[][] score = {{10,6,9,1},{7,5,11,2},{4,8,3,15}};
		int[][] ans = students.kthScore(score, 2);
		students.display(ans);
		
		int[][] score1 = {{3,4},{5,6}};
		int[][] ans1 = students.kthScore(score1, 0);
		students.display(ans1);
	}
}