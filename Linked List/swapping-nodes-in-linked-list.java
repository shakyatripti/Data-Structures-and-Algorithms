//Problem: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/




import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int data) {
        val = data;
    }
    ListNode(int data, ListNode n) {
        val = data;
        next = n;
    }
}

class Swapping {
    public ListNode swapNodes(ListNode head, int k) {
        int size=0, idx=0;
        ListNode head1 = head;
        while(head1!=null) {
            head1 = head1.next;
            size++;
        }
        int[] arr = new int[size];
        while(head!=null) {
            arr[idx] = head.val;
            head = head.next;
            idx++;
        }
        int temp = arr[k-1];
        arr[k-1] = arr[arr.length-k];
        arr[arr.length-k] = temp;
        ListNode list = new ListNode(arr[0]);
        ListNode head2 = list;
        for(int j=1; j<arr.length; j++) {
            list.next = new ListNode(arr[j]);
            list = list.next;
        }
        return head2;
    }
    
    public void display(ListNode ans) {
        while(ans!=null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Swapping ll = new Swapping();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode ans = ll.swapNodes(head, 2);
        ll.display(ans);
        
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(9);
        ListNode ans2 = ll.swapNodes(head2, 1);
        ll.display(ans2);
        
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(3);
        head3.next.next = new ListNode(7);
        head3.next.next.next = new ListNode(2);
        head3.next.next.next.next = new ListNode(6);
        ListNode ans3 = ll.swapNodes(head3, 4);
        ll.display(ans3);
        
    }
}