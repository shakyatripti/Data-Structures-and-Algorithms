//Problem: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/



import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode(int data) {
        val = data;
    }
    ListNode next;
}

class LinkedList {
    public int pairSum(ListNode head) {
        int ans = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(head!=null) {
            arr.add(head.val);
            head = head.next;
        }
        int n = arr.size();
        for(int i=0; i<n/2; i++) {
            int first = arr.get(i);
            int second = arr.get(n-i-1);
            ans = Math.max(ans, first + second);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(list.pairSum(head));
        
        LinkedList list1 = new LinkedList();
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        System.out.println(list1.pairSum(head1));
        
        LinkedList list2 = new LinkedList();
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(100000);
        System.out.println(list2.pairSum(head2));
    }
}