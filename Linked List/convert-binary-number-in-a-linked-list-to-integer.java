//Problem: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/




import java.io.*;
import java.util.*;

class ListNode {
    ListNode next;
    int val;
    ListNode(int data, ListNode n) {
        val = data;
        next = n;
    }
}

class ConvertToInteger {
    public int binaryNumber(ListNode head) {
        int count=0, ans=0;
        ListNode head1 = head;
        while(head1!=null) {
            count++;
            head1 = head1.next;
        }
        while(head!=null) {
            ans+=head.val*(Math.pow(2, count-1));
            count--;
            head = head.next;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        ConvertToInteger num = new ConvertToInteger();
        ListNode head = new ListNode(1, null);
        head.next = new ListNode(0, null);
        head.next.next = new ListNode(1, null);
        System.out.println(num.binaryNumber(head));
        
        ListNode head1 = new ListNode(1, null);
        head1.next = new ListNode(0, null);
        head1.next.next = new ListNode(1, null);
        head1.next.next.next = new ListNode(1, null);
        System.out.println(num.binaryNumber(head1));
        
        ListNode head2 = new ListNode(0, null);
        System.out.println(num.binaryNumber(head2));
        
    }
}




