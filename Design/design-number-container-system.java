//Problem: https://leetcode.com/problems/design-a-number-container-system/description/


import java.util.*;
import java.io.*;

class DesignNumberContainers {
    HashMap<Integer, Integer> mp = new HashMap<>();
    HashMap<Integer, PriorityQueue<Integer>> mp2 = new HashMap<>();
    public DesignNumberContainers() {
        mp = new HashMap<>();
        mp2 = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(mp.containsKey(index) && mp.get(index)==number) {
            return;
        }
        mp.put(index, number);
        mp2.computeIfAbsent(number, k->new PriorityQueue<>()).add(index);
    }
    
    public int find(int number) {
        if(mp2.containsKey(number)) {
            PriorityQueue<Integer> pq = mp2.get(number);
            while(!pq.isEmpty() && mp.get(pq.peek())!=number) {
                pq.poll();
            }
            return pq.isEmpty() ? -1 : pq.peek();
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        DesignNumberContainers container = new DesignNumberContainers();
        System.out.println(container.find(10));
        container.change(2,10);
        container.change(1,10);
        container.change(3,10);
        container.change(5,10);
        System.out.println(container.find(10));
        container.change(1,20);
        System.out.println(container.find(10));
    }
}