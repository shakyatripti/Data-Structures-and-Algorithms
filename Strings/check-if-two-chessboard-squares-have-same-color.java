//Problem: https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/description/





import java.io.*;
import java.util.*;

class ChessBoard {
    public boolean checkSameColor(String coordinate1, String coordinate2) {
        int x1 = coordinate1.charAt(0)-'a';
        int y1 = coordinate1.charAt(1) - '0';
        int x2 = coordinate2.charAt(0) - 'a';
        int y2 = coordinate2.charAt(1) - '0';
        int sum1 = x1 + y1;
        int sum2 = x2 + y2;
        if((sum1%2==0 && sum2%2==0) || (sum1%2!=0 && sum2%2!=0)){
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        System.out.println(board.checkSameColor("a1", "c3"));
        System.out.println(board.checkSameColor("a1", "h3"));
    }
}