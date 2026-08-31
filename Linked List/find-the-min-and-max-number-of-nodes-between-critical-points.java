//Problem: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/





import java.io.*;
import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode (int data) {
        val = data;
    }
    ListNode() {}
}

class CriticalPoints {
    public int[] findMinMaxDist(ListNode head) {
        int count = 1, maxDist = Integer.MIN_VALUE, minDist = Integer.MAX_VALUE;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode prev=null, next=head;
        while(head!=null) {
            if(prev!=null && next!=null) {
                if(head.val > prev.val && head.val > next.val) {
                    arr.add(count);
                }

                if(head.val < prev.val && head.val < next.val) {
                    arr.add(count);
                }
            }
            count++;
            prev = head;
            head = head.next;
            if(head!=null) {
                next = head.next;
            }
        }

        Collections.sort(arr);
        int[] ans = {-1, -1};
        if(arr.size() < 2) {
            return ans;
        }
        for(int i=0; i<arr.size()-1; i++) {
            int diff = arr.get(i+1) - arr.get(i);
            minDist = Math.min(minDist, diff);
        }
        ans[0] = minDist; 
        ans[1] = arr.get(arr.size()-1) - arr.get(0);
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        CriticalPoints node = new CriticalPoints();
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        int[] ans = node.findMinMaxDist(head);
        System.out.println(ans[0] + " " + ans[1]);
        
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(1);
        head1.next.next.next.next.next.next = new ListNode(2);
        int[] ans1 = node.findMinMaxDist(head1);
        System.out.println(ans1[0] + " " + ans1[1]);
        
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);
        head2.next.next.next.next.next = new ListNode(2);
        head2.next.next.next.next.next.next = new ListNode(2);
        head2.next.next.next.next.next.next.next = new ListNode(2);
        head2.next.next.next.next.next.next.next.next = new ListNode(7);
        int[] ans2 = node.findMinMaxDist(head2);
        System.out.println(ans2[0] + " " + ans2[1]);
    }
}