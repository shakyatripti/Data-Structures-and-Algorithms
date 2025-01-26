//Problem: https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/

import java.util.*;
import java.io.*;

class Node {
    int val;
    Node left;
    Node right;
    Node(int data) {
        val = data;
        left=right=null;
    }
}

class KthLargestSum {
    public long kthSum(int k, Node root) {
        ArrayList<Long> arraySum = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        int levels = 0;
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            Long sum=0L;
            levels++;
            for(int i=0; i<size; i++) {
                Node node = q.poll();
                sum+=node.val;
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null) {
                    q.add(node.right);
                }
            }
            arraySum.add(sum);
        }
        if(levels < k) {
            return -1;
        }
        Collections.sort(arraySum);
        return arraySum.get(arraySum.size()-k);
    }
}

class Main {
    public static void main(String[] args) {
         Node root = new Node(5);
         root.left = new Node(6);
         root.right = new Node(2);
         root.left.left = new Node(18);
         root.left.left.left = new Node(4);
         KthLargestSum tree = new KthLargestSum();
         System.out.println(tree.kthSum(2, root));
    }
}