//Problem: https://leetcode.com/problems/create-grid-with-exactly-one-path/description/





import java.io.*;
import java.util.*;


class CreateGrid {
    public String[] exactlyOnePath(int m, int n) {
        String[] ans = new String[m];
        for(int i=0; i<m; i++) {
            String str = "";
            for(int j=0; j<n; j++) {
                if(j==0 || i==m-1) {
                    str+=".";
                } else {
                    str+="#";
                }
            }
            ans[i] = str;
        }
        return ans;
    }
    
    public static void display(String[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        CreateGrid grid = new CreateGrid();
        String[] ans = grid.exactlyOnePath(2,3);
        grid.display(ans);
        
        String[] ans1 = grid.exactlyOnePath(3,3);
        grid.display(ans1);
        
        String[] ans2 = grid.exactlyOnePath(1,4);
        grid.display(ans2);
    }
}