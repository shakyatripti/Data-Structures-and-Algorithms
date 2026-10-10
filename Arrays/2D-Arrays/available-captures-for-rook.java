//Problem: https://leetcode.com/problems/available-captures-for-rook/description/




import java.io.*;
import java.util.*;

class ChessBoard {
    public int numRookCaptures(char[][] board) {
        int rookRow = 0, rookCol = 0, count = 0;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(board[i][j]=='R') {
                    rookRow = i;
                    rookCol = j;
                }
            }
        }
        
        for(int i=rookCol; i<8; i++) {
            if(board[rookRow][i]=='p') {
                count++;
                break;
            } else if(board[rookRow][i]=='B') {
                break;
            }
        }

        for(int i=rookCol; i>=0; i--) {
            if(board[rookRow][i]=='p') {
                count++;
                break;
            } else if(board[rookRow][i]=='B') {
                break;
            }
        }

        for(int i=rookRow; i<8; i++) {
            if(board[i][rookCol]=='p') {
                count++;
                break;
            } else if(board[i][rookCol]=='B') {
                break;
            }
        }

        for(int i=rookRow; i>=0; i--) {
            if(board[i][rookCol]=='p') {
                count++;
                break;
            } else if(board[i][rookCol]=='B') {
                break;
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        ChessBoard mat = new ChessBoard();
        char[][] board = {
          {'.', '.', '.', '.', '.', '.', '.', '.'},
          {'.', '.', '.', 'p', '.', '.', '.', '.'},
          {'.', '.', '.', 'R', '.', '.', '.', 'p'},
          {'.', '.', '.', '.', '.', '.', '.', '.'},
          {'.', '.', '.', '.', '.', '.', '.', '.'},
          {'.', '.', '.', 'p', '.', '.', '.', '.'},
          {'.', '.', '.', '.', '.', '.', '.', '.'},
          {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(mat.numRookCaptures(board));
        
        char[][] board1 = {
          {'.', '.', '.', '.', '.', '.', '.', '.'},
          {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
          {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
          {'.', 'p', 'B', 'R', 'B', 'p', '.', '.'},
          {'.', 'p', 'p', 'B', 'p', 'p', '.', '.'},
          {'.', 'p', 'p', 'p', 'p', 'p', '.', '.'},
          {'.', '.', '.', '.', '.', '.', '.', '.'},
          {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(mat.numRookCaptures(board1));
        
        char[][] board2 = {
          {'.', '.', '.', '.', '.', '.', '.', '.'},
          {'.', '.', '.', 'p', '.', '.', '.', '.'},
          {'.', '.', '.', 'p', '.', '.', '.', '.'},
          {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
          {'.', '.', '.', '.', '.', '.', '.', '.'},
          {'.', '.', '.', 'B', '.', '.', '.', '.'},
          {'.', '.', '.', 'p', '.', '.', '.', '.'},
          {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(mat.numRookCaptures(board2));
    }
}