//Problem: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/




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

class DeleteNodes {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode list = new ListNode(-1);
        ListNode head1 = list;
        HashSet<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            st.add(nums[i]);
        }
        while(head!=null) {
            if(!st.contains(head.val)) {
                list.next = new ListNode(head.val);
                list = list.next;
            }
            head = head.next;
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
        DeleteNodes ll = new DeleteNodes();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(7);
        int[] nums = {1,2,3};
        ListNode ans = ll.modifiedList(nums, head);
        ll.display(ans);
        
        ListNode head1 = new ListNode(6);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(9);
        int[] nums1 = {2,5};
        ListNode ans2 = ll.modifiedList(nums1, head1);
        ll.display(ans2);
        
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(7);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(6);
        int[] nums2 = {1};
        ListNode ans3 = ll.modifiedList(nums2, head2);
        ll.display(ans3);
    }
}