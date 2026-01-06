//Problem: https://leetcode.com/problems/design-hashmap/description/





import java.io.*;
import java.util.*;


class MyHashMap {
    int[] freq;
    public MyHashMap() {
        freq = new int[1000001];
        Arrays.fill(freq, -1);
    }
    
    public void put(int key, int value) {
        freq[key] = value;
    }
    
    public int get(int key) {
        return freq[key];
    }
    
    public void remove(int key) {
        freq[key] = -1;
    }
}

class Main {
    public static void main(String[] args) {
        MyHashMap mp = new MyHashMap();
        mp.put(1,1);
        mp.put(2,2);
        System.out.print(mp.get(1) + " ");
        System.out.print(mp.get(3) + " ");
        mp.put(2,1);
        System.out.print(mp.get(2) + " ");
        mp.remove(2);
        System.out.print(mp.get(2) + " ");
        
        System.out.println();
        
        MyHashMap mp1 = new MyHashMap();
        mp1.put(1000000,1);
        System.out.print(mp1.get(1000000) + " ");
        mp1.put(0,2);
        System.out.print(mp1.get(0) + " ");
    }
}