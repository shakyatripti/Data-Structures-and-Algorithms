//Problem: https://leetcode.com/problems/number-of-recent-calls/description/




import java.io.*;
import java.util.*;


class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        int start = t - 3000;
        q.add(t);
        while(!q.isEmpty() && q.peek()< start) {
            q.poll();
        }
        return q.size();
    }
}

class Main {
    public static void main(String[] args) {
        RecentCounter call = new RecentCounter();
        System.out.print(call.ping(1) + " ");
        System.out.print(call.ping(100) + " ");
        System.out.print(call.ping(3001) + " ");
        System.out.print(call.ping(3002) + " ");
    }
}
