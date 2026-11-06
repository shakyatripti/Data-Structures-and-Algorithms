//Problem: https://leetcode.com/problems/palindrome-linked-list/description/





import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int data) {
        this.val = data;
    }
}

class SinglyLinkedList {
    public boolean isPalindrome(ListNode head) {
        StringBuilder str = new StringBuilder("");
        while(head!=null) {
            str.append(head.val);
            head = head.next;
        }
        String org = str.toString();
        String rev = str.reverse().toString();
        if(org.equals(rev)) {
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(list.isPalindrome(head));
        
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        System.out.println(list.isPalindrome(head1));
    }
}