//Problem: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/




import java.util.*;
import java.io.*;

class SeatEveryOne {
    public int minimumMoves(int[] seats, int[] students) {
        int ans = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for(int i=0; i<seats.length; i++) {
            ans+=Math.abs(seats[i]-students[i]);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        SeatEveryOne moves = new SeatEveryOne();
        int[] seats = {3,1,5};
        int[] students = {2,7,4};
        System.out.println(moves.minimumMoves(seats, students));
        
        int[] seats1 = {4,1,5,9};
        int[] students1 = {1,3,2,6};
        System.out.println(moves.minimumMoves(seats1, students1));
        
        int[] seats2 = {2,2,6,7};
        int[] students2 = {1,3,2,6};
        System.out.println(moves.minimumMoves(seats2, students2));
    }
}