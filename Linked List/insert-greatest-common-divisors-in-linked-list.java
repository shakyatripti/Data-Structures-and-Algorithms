//Problem: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/





import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int data) {
        val = data;
    }
}


class InsertGCDInLinkedList {
    public ListNode insert(ListNode head) {
        ListNode temp = head;
        while(head!=null) {
            ListNode nextNode = head.next;
            if(nextNode!=null) {
                int gcd = calcGCD(nextNode.val, head.val);
                ListNode newNode = new ListNode(gcd);
                head.next = newNode;
                newNode.next = nextNode;
            }
            head = nextNode;
        }
        return temp;
    }

    public int calcGCD(int a, int b) {
        if(b==0) {
            return a;
        }
        return calcGCD(b, a%b);
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
        InsertGCDInLinkedList ll = new InsertGCDInLinkedList();
        ListNode node = new ListNode(18);
        node.next = new ListNode(6);
        node.next.next = new ListNode(10);
        node.next.next.next = new ListNode(3);
        ListNode ans = ll.insert(node);
        ll.display(ans);
        
        ListNode node1 = new ListNode(7);
        ListNode ans1 = ll.insert(node1);
        ll.display(ans1);
    }
}