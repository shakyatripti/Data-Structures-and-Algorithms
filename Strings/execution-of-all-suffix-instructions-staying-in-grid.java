//Problem: https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/description/





import java.io.*;
import java.util.*;

class SuffixInstructions {
    public int[] execute(int n, int[] startPos, String s) {
        int[] ans = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            String str = s.substring(i, s.length());
            ans[i] = movesOff(n, startPos[0], startPos[1], str);
        }
        return ans;
    }

    public int movesOff(int n, int row, int col, String s) {
        int count = 0;
        for(char ch: s.toCharArray()) {
            if(ch=='R') {
                col = col + 1;         
            }else if(ch=='U') {
                row = row - 1;
            }else if(ch=='L') {
                col = col - 1;
            }else if(ch=='D') {
                row = row + 1;
            }

            if(row>=0 && row<n && col>=0 && col<n) {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
    
    public void display(int[] ans) {
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i] +  " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        SuffixInstructions instructions = new SuffixInstructions();
        int[] startPos = {0,1};
        int[] ans = instructions.execute(3, startPos, "RRDDLU");
        instructions.display(ans);
        
        int[] startPos1 = {1,1};
        int[] ans1 = instructions.execute(2, startPos1, "LURD");
        instructions.display(ans1);
        
        int[] startPos2 = {0,0};
        int[] ans2 = instructions.execute(1, startPos1, "LRUD");
        instructions.display(ans2);
        
    }
}