//Problem: https://leetcode.com/problems/time-needed-to-buy-tickets/description/?envType=problem-list-v2&envId=simulation





import java.io.*;
import java.util.*;

class BuyTickets {
    public int timeRequired(int[] tickets, int k) {
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<tickets.length; i++) {
            q.add(i);
        }

        while(tickets[k] > 0) {
            int start = q.poll();
            tickets[start]--;
            if(tickets[start]!=0) {
                q.add(start);
            }
            time++;
        }
        return time;
    }
}

class Main {
    public static void main(String[] args) {
        BuyTickets people = new BuyTickets();
        int[] tickets = {2,3,2};
        System.out.println(people.timeRequired(tickets, 2));
        
        int[] tickets1 = {5,1,1,1};
        System.out.println(people.timeRequired(tickets1, 0));
    }
}