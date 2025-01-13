//Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        data = val;
        left=right=null;
    }
}

class KthSmallestInBST {
    public int kthsmallest(Node root, int k) {
        int count = 0, smallest = -1;
        Stack<Node> s = new Stack<>();
        Node node = root;
        while(true) {
            if(node!=null) {
                s.push(node);
                node = node.left;
            } else {
                if(count == k || s.isEmpty()) {
                    return smallest;
                }
                Node topNode = s.pop();
                count++;
                smallest = topNode.data;
                node = topNode.right;
            }
            
        }
    }
}

class Main {
    public static void main (String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.right = new Node(7);
        root.right.left = new Node(6);
        KthSmallestInBST tree = new KthSmallestInBST();
        System.out.println(tree.kthsmallest(root, 4));
    }
}