//Problem: https://leetcode.com/problems/minimum-queen-moves-to-reach-target/description/




import java.io.*;
import java.util.*;


class QueenMovesToTarget {
    public int minMoves(int[] source, int[] target) {
        int startRow = source[0], startCol = source[1], endRow = target[0], endCol = target[1];
        int diff1 = Math.abs(startRow - endRow);
        int diff2 = Math.abs(startCol-endCol);

        if(startRow==endRow && startCol==endCol) {
            return 0;
        }

        if(startRow==endRow || startCol==endCol || diff1==diff2) {
            return 1;
        }
        return 2;
    }
}

class Main {
    public static void main(String[] args) {
        QueenMovesToTarget queen = new QueenMovesToTarget();
        int[] source = {8,1};
        int[] target = {1,8};
        System.out.println(queen.minMoves(source, target));
        
        int[] source1 = {4,2};
        int[] target1 = {1,3};
        System.out.println(queen.minMoves(source1, target1));
        
        int[] source2 = {1,1};
        int[] target2 = {1,1};
        System.out.println(queen.minMoves(source2, target2));
    }
}