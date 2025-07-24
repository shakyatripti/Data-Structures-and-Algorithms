//Problem: https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/





//Brute Force solution: Using extra space
import java.io.*;
import java.util.*;

class ListNode {
    ListNode next;
    int val;
    ListNode(int data) {
        val = data;
    }
    ListNode(int data, ListNode n) {
        val = data;
        next = n;
    }
}

class ReverseGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        int count = 1;
        ListNode head1 = head;
        while(head!=null) {
            ArrayList<Integer> arr = new ArrayList<>();
            int totalNodes=0;
            for(int j=0; j<count; j++) {
                if(head!=null) {
                    totalNodes++;
                    arr.add(head.val);
                    head = head.next;
                }
            }
            if(totalNodes%2==0) {
                Collections.reverse(arr);
            }
            mp.put(count, arr);
            count++;
        }
        ListNode head2 = head1;
        for(Map.Entry<Integer, ArrayList<Integer>> entry: mp.entrySet()) {
            ArrayList<Integer> arr = entry.getValue();
            for(int i=0; i<arr.size(); i++) {
                head1.val = arr.get(i);
                head1 = head1.next;
            }
        }
        return head2;
    }
    
    public void display(ListNode head) {
        if(head==null) {
            System.out.print("empty");
        }
        while(head!=null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ReverseGroups ll = new ReverseGroups();
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(1);
        ListNode ans = ll.reverseEvenLengthGroups(head);
        ll.display(ans);
        
        
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(9);
        ListNode ans1 = ll.reverseEvenLengthGroups(head1);
        ll.display(ans1);
        
        
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(7);
        head2.next.next = new ListNode(8);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(11);
        ListNode ans2 = ll.reverseEvenLengthGroups(head2);
        ll.display(ans2);
    }
}