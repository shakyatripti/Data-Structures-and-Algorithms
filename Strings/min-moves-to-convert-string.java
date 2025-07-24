//Problem: https://leetcode.com/problems/minimum-moves-to-convert-string/description/




import java.io.*;
import java.util.*;

class ConvertString {
     public int minimumMoves(String s) {
        int i=0, moves=0;
        while(i < s.length()) {
            if(s.charAt(i)=='X') {
                i+=3;
                moves++;
            } else {
                i++;
            }
        }
        return moves;
    }
}

class Main {
    public static void main(String[] args) {
        ConvertString str = new ConvertString();
        System.out.println(str.minimumMoves("XXXO"));
        System.out.println(str.minimumMoves("XXOX"));
        System.out.println(str.minimumMoves("OOO"));
        System.out.println(str.minimumMoves("XXX"));
    }
}