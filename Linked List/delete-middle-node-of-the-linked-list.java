//Problem: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/



import java.io.*;
import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode(int data) {
        val = data;
    }
}


class LinkedList {
    public ListNode deleteMiddle(ListNode head) {
        ListNode ans = new ListNode(-1);
        ListNode head1 = ans;
        ArrayList<Integer> arr = new ArrayList<>();
        while(head!=null) {
            arr.add(head.val);
            head = head.next;
        }
        int n = arr.size();
        for(int i=0; i<n; i++) {
            if(i!=n/2) {
                ans.next = new ListNode(arr.get(i));
                ans = ans.next;
            }
        }
        return head1.next;
    }
    
    public void display(ListNode list) {
        while(list!=null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode ans = list.deleteMiddle(head);
        list.display(ans);
        
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        ListNode ans1 = list.deleteMiddle(head1);
        list.display(ans1);
        
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        ListNode ans2 = list.deleteMiddle(head2);
        list.display(ans2);
    }
}