//Problem: https://leetcode.com/problems/binary-tree-inorder-traversal/description/

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        data = val;
        left=right=null;
    }
}

class InorderTraversal {
    public static void inorder(Node root, List<Integer> values) {
        if(root == null) {
            return;
        }
        inorder(root.left, values);
        values.add(root.data);
        inorder(root.right, values);
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> values = new ArrayList<Integer>();
        InorderTraversal tree = new InorderTraversal();
        tree.inorder(root, values);
        for(int elements: values) {
            System.out.println(elements);
        }
    }
}