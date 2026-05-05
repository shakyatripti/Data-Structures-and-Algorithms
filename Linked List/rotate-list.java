//Problem: https://leetcode.com/problems/rotate-list/description/




import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int num) {
        this.val = num;
    }
}
class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode ans = new ListNode();
        ListNode head1 = head, head2 = ans;
        while(head1!=null) {
            arr.add(head1.val);
            head1 = head1.next;
            size++;
        }
        if(k==0 || size==0) {
            return head;
        }
        k = k%size;
        int rem = size - k;
        for(int i=rem; i<size; i++) {
            ans.next = new ListNode(arr.get(i));
            ans = ans.next;
        }
        for(int i=0; i<rem; i++) {
            ans.next = new ListNode(arr.get(i));
            ans = ans.next;
        }
        return head2.next;
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
        RotateList list = new RotateList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode ans = list.rotateRight(head, 2);
        list.display(ans);
        
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        ListNode ans1 = list.rotateRight(head1, 4);
        list.display(ans1);
        
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        ListNode ans2 = list.rotateRight(head2, 1);
        list.display(ans2);
    }
}