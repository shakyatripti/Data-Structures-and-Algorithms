//Problem: https://leetcode.com/problems/minimum-bishop-moves-to-reach-target/description/





import java.io.*;
import java.util.*;

class ChessBoard {
    public int minBishopMoves(int[] source, int[] target) {
        int diff = Math.abs(source[0] - target[0]);
        int diff1 = Math.abs(source[1] - target[1]);
        int pos1 = source[0] + source[1];
        int pos2 = target[0] + target[1];
        if(pos1%2!=pos2%2) {
            return -1;
        } else if(diff == diff1) {
            return 1;
        }
        return 2;
    }
}

class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        int[] source = {8,1};
        int[] target = {1,8};
        System.out.println(board.minBishopMoves(source, target));
        
        int[] source1 = {4,2};
        int[] target1 = {1,3};
        System.out.println(board.minBishopMoves(source1, target1));
        
        int[] source2 = {1,1};
        int[] target2 = {3,4};
        System.out.println(board.minBishopMoves(source2, target2));
    }
}