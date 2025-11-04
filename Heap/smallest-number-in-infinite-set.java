//Problem: https://leetcode.com/problems/smallest-number-in-infinite-set/description/





import java.io.*;
import java.util.*;

class SmallestInfiniteSet {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> Integer.compare(a, b));
    public SmallestInfiniteSet() {
        for(int i=1; i<=1000; i++) {
            pq.add(i);
        }
    }
    
    public int popSmallest() {
        return pq.poll();
    }
    
    public void addBack(int num) {
        if(!pq.contains(num)) {
           pq.add(num);
        }
    }
}



class Main {
    public static void main(String[] args) {
        SmallestInfiniteSet set = new SmallestInfiniteSet();
        set.addBack(2);
        System.out.println(set.popSmallest());
        System.out.println(set.popSmallest());
        System.out.println(set.popSmallest());
        set.addBack(1);
        System.out.println(set.popSmallest());
        System.out.println(set.popSmallest());
        System.out.println(set.popSmallest());
    }
}