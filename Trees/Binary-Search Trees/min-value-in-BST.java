// Problem: https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1

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

class BinarySearchTree {
    public int minNodeInBST(Node root) {
        int min=0;
        while(root!= null) {
            min = root.data;
            root = root.left;
        }
        return min;
    }
}

class Main {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.left.right.right = new Node(4);
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.minNodeInBST(root));
    }
}