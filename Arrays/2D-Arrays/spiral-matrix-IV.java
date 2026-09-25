//Problem: https://leetcode.com/problems/spiral-matrix-iv/description/




import java.io.*;
import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class SpiralMatrixIV {
    public int[][] generate(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        int start=0, row=m-1, col=n-1;
        for(int i=0; i<m; i++) {
            Arrays.fill(ans[i], -1);
        }
        while(head!=null) {
            head = traverse(start,row,col, ans, head);
            start++;
            row--;
            col--;
        }
        return ans;
    }

    public ListNode traverse(int start, int row, int col, int[][] ans, ListNode head) {
        for(int j=start; j<=col; j++) {
            if(head!=null) {
                ans[start][j] = head.val;
                head=head.next;
            }
        }

        for(int i=start+1; i<=row; i++) {
            if(head!=null) {
                ans[i][col] = head.val;
                head=head.next;
            }
        }

        if(start < row) {
            for(int j=col-1; j>=start; j--) {
                if(head!=null) {
                    ans[row][j] = head.val;
                    head = head.next;
                }
            }
        }

        if(start < col) {
            for(int i=row-1; i>start; i--) {
                if(head!=null) {
                    ans[i][start] = head.val;
                    head = head.next;
                }
            }
        }
        return head;
    }
    
    public void display(int[][] ans) {
        for(int i=0; i<ans.length; i++) {
            for(int j=0; j<ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        SpiralMatrixIV matrix = new SpiralMatrixIV();
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next= new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        int[][] ans = matrix.generate(3,5,head);
        matrix.display(ans);
        
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        int[][] ans1 = matrix.generate(1,4,head1);
        matrix.display(ans1);
        
    }
    
}