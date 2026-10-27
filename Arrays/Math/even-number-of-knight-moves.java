//Problem: https://leetcode.com/problems/even-number-of-knight-moves/description/




import java.io.*;
import java.util.*;

class ChessBoard {
    public boolean knightMovesToReach(int[] start, int[] target) {
        int s1 = start[0] + start[1];
        int s2 = target[0] + target[1];
        if(s1%2==s2%2) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        int[] start = {1,1};
        int[] target = {2,2};
        System.out.println(board.knightMovesToReach(start, target));
        
        int[] start1 = {4,5};
        int[] target1 = {6,6};
        System.out.println(board.knightMovesToReach(start1, target1));
    }
}