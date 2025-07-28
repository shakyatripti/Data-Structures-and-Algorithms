//Problem: https://leetcode.com/problems/remove-nodes-from-linked-list/description/





import java.io.*;
import java.util.*;

class ListNode {
    ListNode next;
    int val;
    ListNode(int data) {
        val = data;
    }
    ListNode() {}
}

class RemoveNodes {
    public ListNode remove(ListNode head) {
        ListNode head1 = head, prev = null;
        while(head1!=null) {
           ListNode nextNode = head1.next;
           head1.next = prev;
           prev = head1;
           head1 = nextNode;
        }
        Stack<Integer> st = new Stack<>();
        int top = prev.val;
        st.push(top);
        prev = prev.next;
        while(prev!=null) {
            if(prev.val >= top) {
                st.add(prev.val);
            }
            top = Math.max(top, st.peek());
            prev = prev.next;
        }
        ListNode ll = new ListNode(-1), head3 = ll;
        while(!st.isEmpty()) {
            ll.next = new ListNode(st.pop());
            ll = ll.next;
        }
        return head3.next;
    }
    
    public void display(ListNode head) {
        while(head!=null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}


class Main {
    public static void main(String[] args) {
        RemoveNodes ll = new RemoveNodes();
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        ListNode ans = ll.remove(head);
        ll.display(ans);
        
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(1);
        ListNode ans1 = ll.remove(head1);
        ll.display(ans1);
    }
}