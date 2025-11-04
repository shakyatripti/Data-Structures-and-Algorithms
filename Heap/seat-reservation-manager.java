//Problem: https://leetcode.com/problems/seat-reservation-manager/description/




import java.io.*;
import java.util.*;

class SeatManager {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> Integer.compare(a, b));
    public SeatManager(int n) {
        for(int i=1; i<=n; i++) {
            pq.add(i);
        }
    }
    
    public int reserve() {
        return pq.poll();
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}


class Main {
    public static void main(String[] args) {
        SeatManager seat = new SeatManager(5);
        System.out.println(seat.reserve());
        System.out.println(seat.reserve());
        seat.unreserve(2);
        System.out.println(seat.reserve());
        System.out.println(seat.reserve());
        System.out.println(seat.reserve());
        System.out.println(seat.reserve());
        seat.unreserve(5);
        System.out.println(seat.reserve());
    }
}