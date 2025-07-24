//Problem: https://leetcode.com/problems/linked-list-components/description/




import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int data) {
        val = data;
    }
}

class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> arr = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            arr.add(nums[i]);
        }
        int component=0, ans=0;
        boolean flag = false;
        while(head!=null) {
            if(!arr.contains(head.val)) {
                component++;
                flag = false;
            } else {
                if(flag==false) {
                    ans++;
                    flag=true;
                }
            }
            head=head.next;
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedListComponents ll = new LinkedListComponents();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        int[] nums = {0,1,3};
        System.out.println(ll.numComponents(head, nums));
        
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(6);
        head1.next.next.next = new ListNode(9);
        int[] nums1 = {5,9};
        System.out.println(ll.numComponents(head1, nums1));
        
        
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(11);
        head2.next.next.next.next = new ListNode(16);
        head2.next.next.next.next.next = new ListNode(2);
        head2.next.next.next.next.next.next = new ListNode(8);
        int[] nums2 = {3,8,11,2};
        System.out.println(ll.numComponents(head2, nums2));
    }
}