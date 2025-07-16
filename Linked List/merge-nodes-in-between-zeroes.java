//Problem: https://leetcode.com/problems/merge-nodes-in-between-zeros/description/




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

class MergeNodes {
    public ListNode merge(ListNode head) {
        ListNode list = new ListNode(-1), curr = head.next, head1 = list;
        int sum = 0;
        while(curr!=null) {
            if(curr.val==0) {
                list.next = new ListNode(sum);
                list = list.next;
                sum = 0;
            } else {
                sum+=curr.val;
            }
            curr=curr.next;
        }
        return head1.next;
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
        MergeNodes ll = new MergeNodes();
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(11);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(0);
        head.next.next.next = new ListNode(0, head1);
        ListNode ans = ll.merge(head);
        ll.display(ans);
        
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(0);
        ListNode ans2 = ll.merge(head2);
        ll.display(ans2);
        
        ListNode head3 = new ListNode(0);
        head3.next = new ListNode(3);
        head3.next.next = new ListNode(0);
        ListNode head4 = new ListNode(0);
        head4.next = new ListNode(7);
        head4.next.next = new ListNode(1);
        head4.next.next.next = new ListNode(2);
        head3.next.next.next = new ListNode(6, head4);
        head4.next.next.next.next = new ListNode(0);
        ListNode ans3 = ll.merge(head3);
        ll.display(ans3);
        
    }
}