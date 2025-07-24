//Problem: https://leetcode.com/problems/merge-two-sorted-lists/description/




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

class MergeLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) {
           return list1;
        }
        if(list1==null && list2!=null) {
            return list2;
        }
        if(list1!=null && list2==null) {
            return list1;
        }
        ListNode list3 = new ListNode(-1);
        ListNode head=list3;
        while(list1!=null && list2!=null) {
            if(list2!=null && list1.val < list2.val) {
                list3.next = new ListNode(list1.val);
                list1 = list1.next;
                list3 = list3.next;
            } else if(list2!=null && list1.val == list2.val) {
                list3.next = new ListNode(list1.val);
                list3 = list3.next;
                list3.next = new ListNode(list2.val);
                list3 = list3.next;
                list1 = list1.next;
                list2 = list2.next;
            } else {
                list3.next = list2;
                list2 = list2.next;
                list3 = list3.next;
            }
        }
        while(list1!=null) {
            list3.next = new ListNode(list1.val);
            list3 = list3.next;
            list1 = list1.next;
        }
        while(list2!=null) {
            list3.next = new ListNode(list2.val);
            list3 = list3.next;
            list2 = list2.next;
        }
        return head.next;
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
        MergeLists ll = new MergeLists();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode ans = ll.mergeTwoLists(list1, list2);
        ll.display(ans);
        
        
        ListNode list3 = new ListNode(1);
        list3.next = new ListNode(4);
        ListNode list4 = new ListNode(1);
        list4.next = new ListNode(3);
        list4.next.next = new ListNode(4);
        list4.next.next.next = new ListNode(6);
        ListNode ans1 = ll.mergeTwoLists(list3, list4);
        ll.display(ans1);
        
        
        ListNode list5 = null;
        ListNode list6 = new ListNode(11);
        list6.next = new ListNode(12);
        list6.next.next = new ListNode(23);
        ListNode ans2 = ll.mergeTwoLists(list5, list6);
        ll.display(ans2);
        
               
        ListNode list7 = new ListNode(5);
        list7.next = new ListNode(8);
        list7.next.next = new ListNode(12);
        ListNode list8 = null;
        ListNode ans3 = ll.mergeTwoLists(list7, list8);
        ll.display(ans3);
        
    }
}