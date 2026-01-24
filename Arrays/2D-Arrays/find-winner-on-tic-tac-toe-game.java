//Problem: https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/description/





import java.io.*;
import java.util.*;

class TicTacToe {
    public String findWinner(int[][] moves) {
        int[][] mat = new int[3][3];
        int k=0;
        for(int i=0; i<moves.length; i++) {
            if(k%2==0) {
                mat[moves[i][0]][moves[i][1]] = 2;
            } else {
                mat[moves[i][0]][moves[i][1]] = 3;
            }
            k++;
        }
        if(isRowSame(mat, 2) || isColumnSame(mat, 2) || isDiagonalSame(mat, 2)) {
            return "A";
        }
        if(isRowSame(mat, 3) || isColumnSame(mat, 3) || isDiagonalSame(mat, 3)) {
            return "B";
        }
        if(moves.length==9) {
            return "Draw";
        }
        return "Pending";
    }

    public boolean isRowSame(int[][] mat, int x) {
        for(int i=0; i<3; i++) {
            if(mat[i][0]==x && mat[i][1]==x && mat[i][2]==x) {
                return true;
            }
        }
        return false;
    }

    public boolean isColumnSame(int[][] mat, int x) {
        for(int i=0; i<3; i++) {
            if(mat[0][i]==x && mat[1][i]==x && mat[2][i]==x) {
                return true;
            }
        }
        return false;
    }

    public boolean isDiagonalSame(int[][] mat, int x) {
        if(mat[0][0]==x && mat[1][1]==x && mat[2][2]==x) {
            return true;
        }
        if(mat[2][0]==x && mat[1][1]==x && mat[0][2]==x) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        System.out.println(game.findWinner(moves));
        
        int[][] moves1 = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(game.findWinner(moves1));
        
        int[][] moves2 = {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
        System.out.println(game.findWinner(moves2));
    }
}