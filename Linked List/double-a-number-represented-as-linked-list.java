//Problem: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/



import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int data) {
        this.val = data;
    }
    ListNode(int data, ListNode next) {
        this.val = data;
        this.next = next;
    }
}


class SinglyLinkedList {
    public ListNode doubleIt(ListNode head) {
        int carry = 0;
        Stack<Integer> st = new Stack<>();
        ListNode ans = new ListNode(-1);
        ListNode head1 = ans;
        while(head!=null) {
            st.add(head.val);
            head = head.next;
        }

        Stack<Integer> doubleVal = new Stack<>();
        while(!st.isEmpty()) {
            int curr = st.pop();
            int val = curr * 2 + carry;

            carry = val / 10;
            doubleVal.push(val % 10);
        }

        if(carry > 0) {
            doubleVal.push(carry);
        }

        while(!doubleVal.isEmpty()) {
            ans.next = new ListNode(doubleVal.pop(), null);
            ans = ans.next;
        }
        return head1.next;
    }
    
    public void display(ListNode head) {
        while(head!=null) {
            System.out.print(head.val + " ");
            head=head.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(9);
        ListNode ans = list.doubleIt(head);
        list.display(ans);
        
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);
        ListNode ans1 = list.doubleIt(head1);
        list.display(ans1);
        
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(2);
        head2.next.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next.next.next = new ListNode(9);
        head2.next.next.next.next.next.next.next.next = new ListNode(9);
        head2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode ans2 = list.doubleIt(head2);
        list.display(ans2);
    }
}