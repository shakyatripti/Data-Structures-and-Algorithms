//Problem: https://leetcode.com/problems/design-linked-list/description/




import java.io.*;
import java.util.*;

class DesignLinkedList {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    public DesignLinkedList() {
        arr = new ArrayList<Integer>();
    }
    
    public int get(int index) {
        if(index >=0 && index < arr.size()) {
            return arr.get(index);
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        arr.add(0, val);
    }
    
    public void addAtTail(int val) {
        arr.add(arr.size(), val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index >=0 && index <= arr.size()) {
            arr.add(index, val);
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index >= 0 && index < arr.size()) {
            arr.remove(index);
        }
    }
}


class Main {
    public static void main(String[] args) {
        DesignLinkedList ll = new DesignLinkedList();
        ll.addAtIndex(0, 11);
        ll.addAtHead(2);
        ll.addAtHead(8);
        ll.addAtTail(13);
        System.out.println(ll.get(1));
        ll.deleteAtIndex(1);
        System.out.println(ll.get(1));
        
        
        DesignLinkedList ll1 = new DesignLinkedList();
        ll1.deleteAtIndex(1);
        System.out.println(ll1.get(1));
    }
}