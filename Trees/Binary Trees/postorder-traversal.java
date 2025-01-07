//Problem: https://leetcode.com/problems/binary-tree-postorder-traversal/description/

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        data = val;
    }
}

class PostOrderTraversal {
    public static void postorder(Node root, List<Integer> values) {
        if(root == null) {
            return;
        }
        postorder(root.left, values);
        postorder(root.right, values);
        values.add(root.data);
    }
}

class Main  {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.left.right = new Node(6);
        PostOrderTraversal tree = new PostOrderTraversal();
        List<Integer> values = new ArrayList<Integer>();
        tree.postorder(root, values);
        for(int ele: values) {
            System.out.println(ele);
        }
    }
}