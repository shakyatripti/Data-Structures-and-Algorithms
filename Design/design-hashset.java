//Problem: https://leetcode.com/problems/design-hashset/description/



import java.io.*;
import java.util.*;

class MyHashSet {
    Set<Integer> st = new HashSet<>();
    public MyHashSet() {
        st = new HashSet<>();
    }
    
    public void add(int key) {
        st.add(key);
    }
    
    public void remove(int key) {
        st.remove(key);
    }
    
    public boolean contains(int key) {
        if(st.contains(key)) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        MyHashSet mp = new MyHashSet();
        mp.add(1);
        mp.add(2);
        System.out.print(mp.contains(1) + " ");
        System.out.print(mp.contains(3) + " ");
        mp.add(2);
        System.out.print(mp.contains(2) + " ");
        mp.remove(2);
        System.out.print(mp.contains(2) + " ");
    }
}