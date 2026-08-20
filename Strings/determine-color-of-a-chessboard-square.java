//Problem: https://leetcode.com/problems/determine-color-of-a-chessboard-square/description/





import java.io.*;
import java.util.*;


class Chessboard {
    public boolean squareIsWhite(String coordinates) {
        int first = coordinates.charAt(0) - 'a';
        int second = coordinates.charAt(1) - '0';
        int total = first + second;
        if(total%2==0) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Chessboard chess = new Chessboard();
        System.out.println(chess.squareIsWhite("a1"));
        System.out.println(chess.squareIsWhite("h3"));
        System.out.println(chess.squareIsWhite("c7"));
    }
}